package com.group08.onlineShop.service;

import com.group08.onlineShop.model.City;
import com.group08.onlineShop.model.Commune;
import com.group08.onlineShop.model.District;

import java.util.List;

public interface AddressService {
    /**
     * get all cities at Vietnam
     * @return list of city
     */
    List<City> getAllCities();

    /**
     * get all districts of city
     * @return list of district
     */
    List<District> getDistrictsOfCity(Integer cityId);

    /**
     * get all communes of district
     * @return list of commune
     */
    List<Commune> getAllCommunesOfDistrict(Integer districtId);

}
