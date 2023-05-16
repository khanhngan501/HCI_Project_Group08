package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommuneRepo extends JpaRepository<Commune, Long> {
    List<Commune> findCommunesByDistrictId(Long districtID);
}
