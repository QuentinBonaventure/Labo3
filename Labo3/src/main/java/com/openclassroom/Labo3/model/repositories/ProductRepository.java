package com.openclassroom.Labo3.model.repositories;

import com.openclassroom.Labo3.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer>  {

}
