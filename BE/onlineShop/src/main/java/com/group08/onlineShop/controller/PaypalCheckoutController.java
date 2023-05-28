package com.group08.onlineShop.controller;

import com.group08.onlineShop.config.PayPalHttpClient;
import com.group08.onlineShop.dto.PayPalDTO.PayPalAppContextDTO;
import com.group08.onlineShop.dto.PayPalDTO.PayPalOrderDTO;
import com.group08.onlineShop.dto.PayPalDTO.PaymentLandingPage;
import com.group08.onlineShop.dto.responseDTO.PayPalOrderResponseDTO;
import com.group08.onlineShop.dto.responseDTO.PayPalOrderStatus;
import com.group08.onlineShop.model.PayPalOrder;
import com.group08.onlineShop.repository.PayPalOrderRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "api/v1")
@Slf4j
@RequiredArgsConstructor
public class PaypalCheckoutController {

    private final PayPalHttpClient payPalHttpClient;
    private final PayPalOrderRepo payPalOrderRepo;

    @PostMapping("/checkout")
    public ResponseEntity<PayPalOrderResponseDTO> checkout(@RequestBody PayPalOrderDTO orderDTO) throws Exception {
        var appContext = new PayPalAppContextDTO();
        appContext.setReturnUrl("http://localhost:8080/checkout/success");
        appContext.setBrandName("My brand");
        appContext.setLandingPage(PaymentLandingPage.BILLING);
        orderDTO.setApplicationContext(appContext);
        var orderResponse = payPalHttpClient.createOrder(orderDTO);

        var entity = new PayPalOrder();
        entity.setPaypal_order_id(orderResponse.getId());
        entity.setPaypal_order_status(orderResponse.getStatus().toString());
        var out = payPalOrderRepo.save(entity);
        log.info("Saved order: {}", out);
        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping("/checkout/success")
    public ResponseEntity<String> paymentSuccess(HttpServletRequest request) {
        var orderId = request.getParameter("token");
        var out = payPalOrderRepo.findPayPalOrderById(orderId);
        out.setPaypal_order_status(PayPalOrderStatus.APPROVED.toString());
        payPalOrderRepo.save(out);
        return ResponseEntity.ok().body("Payment success");
    }
}
