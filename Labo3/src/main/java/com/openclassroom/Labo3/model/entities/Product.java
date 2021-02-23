package com.openclassroom.Labo3.model.entities;

import lombok.*;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class Product {

    private int id;

    private String descrption;



}
