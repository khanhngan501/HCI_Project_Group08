package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommuneRepo extends JpaRepository<Commune, Integer> {

    @Query(value = "SELECT * FROM commune u WHERE u.district_id = ?1", nativeQuery = true)
    Optional<List<Commune>> getAllCommunesOfDistrict(Integer districtId);

}
