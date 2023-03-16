package com.group08.onlineShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @Entity
@AllArgsConstructor
@NoArgsConstructor @Builder
public class Role {

    @Id
    @SequenceGenerator(
            name = "role_id_sequence",
            sequenceName = "role_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_id_sequence"
    )
    private Integer roleId;

    private String name;
}

