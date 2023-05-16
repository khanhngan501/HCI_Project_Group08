package com.group08.onlineShop.service;

import com.group08.onlineShop.dto.requestDTO.AddressRequest;
import com.group08.onlineShop.dto.responseDTO.AddressResponse;
import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.exception.ResourceNotFoundException;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAllAddress();
    AddressResponse getAddressByID(Long addressID) throws ResourceNotFoundException;
    AddressResponse createAddress(AddressRequest addressRequest);
    AddressResponse updateAddress(Long addressID, AddressRequest addressRequest);
    ApiResponse deleteAddress(Long addressID);
}