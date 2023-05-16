package com.group08.onlineShop.service.impl;

import com.group08.onlineShop.dto.requestDTO.AddressRequest;
import com.group08.onlineShop.dto.responseDTO.AddressResponse;
import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.dto.responseDTO.StockResponse;
import com.group08.onlineShop.exception.ResourceNotFoundException;
import com.group08.onlineShop.model.Address;
import com.group08.onlineShop.model.Stock;
import com.group08.onlineShop.repository.AddressRepo;
import com.group08.onlineShop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    @Override
    public List<AddressResponse> getAllAddress() {
        List<Address> addresses = addressRepo.findAll();
        return addAddressResponse(addresses);
    }

    @Override
    public AddressResponse getAddressByID(Long addressID) throws ResourceNotFoundException {
        Address address = addressRepo.findById(addressID).orElseThrow(()
        -> new ResourceNotFoundException("Address", "addressID", addressID));
        return new AddressResponse(address.getId(), address.getCity().getName(),
                address.getDistrict().getName(), address.getCommune().getName(), address.getDetailAddress());
    }

    @Override
    public AddressResponse createAddress(AddressRequest addressRequest) {

        return null;
    }

    @Override
    public AddressResponse updateAddress(Long addressID, AddressRequest addressRequest) {
        return null;
    }

    @Override
    public ApiResponse deleteAddress(Long addressID) {
        return null;
    }
    private List<AddressResponse> addAddressResponse(List<Address> addresses){
        List<AddressResponse> addressResponses = new ArrayList<>(addresses.size());
        for(Address address : addresses) {
            addressResponses.add(new AddressResponse(address.getId(), address.getCity().getName(),
                    address.getDistrict().getName(), address.getCommune().getName(), address.getDetailAddress()));
        }
        return addressResponses;
    }
}
