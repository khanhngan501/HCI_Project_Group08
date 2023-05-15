package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

//    @Modifying
//    @Query(value = "DELETE FROM address u WHERE u.order_id = ?1", nativeQuery = true)
//    Integer deletingAddress(Integer orderId);

}
