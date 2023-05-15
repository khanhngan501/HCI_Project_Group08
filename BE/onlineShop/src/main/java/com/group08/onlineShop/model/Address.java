package com.group08.onlineShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @Entity
@Builder @NoArgsConstructor @AllArgsConstructor
public class Address {

    @Id
    @SequenceGenerator(
            name = "address_id_sequence",
            sequenceName = "address_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_id_sequence"
    )
    private Integer id;

//    @OneToOne
//    @JoinColumn(name = "order_id")
//    private OrderItems orderItems;

    private Integer city_id;

    private Integer district_id;

    private Integer commune_id;

    private String details;

}
