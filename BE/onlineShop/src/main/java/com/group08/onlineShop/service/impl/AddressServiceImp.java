package com.group08.onlineShop.service.impl;

import com.group08.onlineShop.model.City;
import com.group08.onlineShop.model.Commune;
import com.group08.onlineShop.model.District;
import com.group08.onlineShop.repository.CityRepo;
import com.group08.onlineShop.repository.CommuneRepo;
import com.group08.onlineShop.repository.DistrictRepo;
import com.group08.onlineShop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {
    @Autowired
    CityRepo cityRepo;

    @Autowired
    DistrictRepo districtRepo;

    @Autowired
    CommuneRepo communeRepo;

    @Override
    public List<City> getAllCities() {
        return cityRepo.getAllCities();
    }

    @Override
    public List<District> getDistrictsOfCity(Integer cityId) {

        List<District> results = districtRepo.getDistrictOfCity(cityId).orElseThrow(
                () -> new RuntimeException("Not found districts!")
        );
        return results;
    }

    @Override
    public List<Commune> getAllCommunesOfDistrict(Integer districtId) {

        List<Commune> results = communeRepo.getAllCommunesOfDistrict(districtId).orElseThrow(
                () -> new RuntimeException("Not found communes!")
        );
        return results;
    }

}
