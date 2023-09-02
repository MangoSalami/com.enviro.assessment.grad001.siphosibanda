package com.enviro.assessment.grad001.siphosibanda.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "withdrawal_notice")
public class WithdrawalNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @ManyToOne
    @JsonProperty("product_id")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "withdrawal_amount")
    @JsonProperty("withdrawal_amount")
    private BigDecimal withdrawalAmount;
    public Product getProduct(){
            return product;
}

    public BigDecimal getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public Long getId() {
        return id;
    }



    // Getters and setters...
}
