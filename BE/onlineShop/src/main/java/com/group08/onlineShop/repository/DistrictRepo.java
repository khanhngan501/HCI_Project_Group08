package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepo extends JpaRepository<District, Integer> {

    @Query(value = "SELECT * FROM district u WHERE u.city_id = ?1", nativeQuery = true)
    Optional<List<District>> getDistrictOfCity(Integer cityId);

}
