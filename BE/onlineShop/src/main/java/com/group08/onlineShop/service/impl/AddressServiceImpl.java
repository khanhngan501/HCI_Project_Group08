package com.group08.onlineShop.service.impl;

import com.group08.onlineShop.dto.requestDTO.AddressRequest;
import com.group08.onlineShop.dto.responseDTO.AddressResponse;
import com.group08.onlineShop.dto.responseDTO.ApiResponse;
import com.group08.onlineShop.exception.BadRequestException;
import com.group08.onlineShop.exception.ResourceNotFoundException;
import com.group08.onlineShop.model.*;
import com.group08.onlineShop.repository.AddressRepo;
import com.group08.onlineShop.repository.CityRepo;
import com.group08.onlineShop.repository.CommuneRepo;
import com.group08.onlineShop.repository.DistrictRepo;
import com.group08.onlineShop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    private final CityRepo cityRepo;
    private final DistrictRepo districtRepo;
    private final CommuneRepo communeRepo;
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
    public AddressResponse createAddress(AddressRequest addressRequest) throws ResourceNotFoundException {
        City city = cityRepo.findById(addressRequest.getCity()).orElseThrow(()
        -> new ResourceNotFoundException("City", "cityID", addressRequest.getCity()));
        District district = districtRepo.findById(addressRequest.getDistrict()).orElseThrow(()
                -> new ResourceNotFoundException("District", "districtID", addressRequest.getDistrict()));
        Commune commune = communeRepo.findById(addressRequest.getCommune()).orElseThrow(()
                -> new ResourceNotFoundException("City", "communeID", addressRequest.getDetailAddress()));
        var address = Address.builder()
                .city(city)
                .district(district)
                .commune(commune)
                .detailAddress(addressRequest.getDetailAddress())
                .build();
        addressRepo.save(address);
        return new AddressResponse(address.getId(), address.getCity().getName(),
                address.getDistrict().getName(), address.getCommune().getName(), address.getDetailAddress());
    }

    @Override
    public AddressResponse updateAddress(Long addressID, AddressRequest addressRequest) throws ResourceNotFoundException {
        Address address = addressRepo.findById(addressID).orElseThrow(()
        -> new ResourceNotFoundException("Address", "addressID", addressID));
        City city = cityRepo.findById(addressRequest.getCity()).orElseThrow(()
                -> new ResourceNotFoundException("City", "cityID", addressRequest.getCity()));
        District district = districtRepo.findById(addressRequest.getDistrict()).orElseThrow(()
                -> new ResourceNotFoundException("District", "districtID", addressRequest.getDistrict()));
        Commune commune = communeRepo.findById(addressRequest.getCommune()).orElseThrow(()
                -> new ResourceNotFoundException("City", "communeID", addressRequest.getDetailAddress()));
        if (address != null) {
            address.setCity(city);
            address.setDistrict(district);
            address.setCommune(commune);
            address.setDetailAddress(addressRequest.getDetailAddress());
            Address updatedAddress = addressRepo.save(address);
            return new AddressResponse(updatedAddress.getId(), updatedAddress.getCity().getName(),
                    updatedAddress.getDistrict().getName(), updatedAddress.getCommune().getName(),
                    updatedAddress.getDetailAddress());
        }
        ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Can not update address", HttpStatus.BAD_REQUEST.value());
        throw new BadRequestException(apiResponse);
    }

    @Override
    public ApiResponse deleteAddress(Long addressID) throws ResourceNotFoundException {
        Address address = addressRepo.findById(addressID).orElseThrow(()
                -> new ResourceNotFoundException("Address", "addressID", addressID));
        if (address != null) {
            addressRepo.deleteById(addressID);
            return new ApiResponse(Boolean.TRUE, "Address deleted successfully");
        }
        ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Can not delete address", HttpStatus.BAD_REQUEST.value());
        throw new BadRequestException(apiResponse);
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
