package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepo extends JpaRepository<District, Long> {
    List<District> findDistrictsByCityId(Long cityID);
}
