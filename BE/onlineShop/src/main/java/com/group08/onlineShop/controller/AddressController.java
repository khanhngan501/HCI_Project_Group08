package com.group08.onlineShop.controller;

import com.group08.onlineShop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


@RestController @RequiredArgsConstructor
@RequestMapping("api/v1")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/cities")
    public ResponseEntity<?> getAllCities() {

        return ResponseEntity.ok(addressService.getAllCities());
    }

    @GetMapping("/districts")
    public ResponseEntity<?> getDistricts(@RequestParam("city")Integer cityId) {

        return ResponseEntity.ok(addressService.getDistrictsOfCity(cityId));
    }

    @GetMapping("/communes")
    public ResponseEntity<?> getCommunes(@RequestParam("district")Integer districtId){

        return  ResponseEntity.ok(addressService.getAllCommunesOfDistrict(districtId));
    }

}
