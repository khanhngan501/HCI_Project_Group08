package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends JpaRepository<City, Integer> {

    @Query(value = "SELECT * FROM city", nativeQuery = true)
    List<City> getAllCities();

}
