package com.enviro.assessment.grad001.siphosibanda.Service;

import com.enviro.assessment.grad001.siphosibanda.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
