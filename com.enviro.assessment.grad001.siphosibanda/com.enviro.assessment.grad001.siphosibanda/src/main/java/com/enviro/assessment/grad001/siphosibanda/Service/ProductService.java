package com.enviro.assessment.grad001.siphosibanda.Service;
import com.enviro.assessment.grad001.siphosibanda.Models.Investor;
import com.enviro.assessment.grad001.siphosibanda.Models.Product;
import org.springframework.stereotype.Service;
import java.lang.Long;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final InvestorRepository investorRepository;


    public ProductService(ProductRepository productRepository, InvestorRepository investorRepository) {
        this.productRepository = productRepository;
        this.investorRepository = investorRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product addProduct(Product product) {
        Investor investor = product.getInvestor();
        Long investorId=investor.getId();
        Investor existingInvestor = investorRepository.findById(investorId)
                .orElseThrow(() -> new IllegalArgumentException("Investor not found with ID: " + investorId));



        if (!isValidProduct(product)) {
            throw new IllegalArgumentException("Invalid investor: Age less than 65 for retirement product.");
        }
        return productRepository.save(product);
    }

    private boolean isValidProduct(Product product) {
        Investor investor = product.getInvestor();
        String productType = product.getType();
        Long id= investor.getId();
        investor=investorRepository.findById(id).orElse(null);
        // Check if age is less than 65 and product type is "retirement"
        return !(investor != null &&
                investor.getAge() < 65 &&
                "retirement".equalsIgnoreCase(productType));
    }
    // Other methods...
}
