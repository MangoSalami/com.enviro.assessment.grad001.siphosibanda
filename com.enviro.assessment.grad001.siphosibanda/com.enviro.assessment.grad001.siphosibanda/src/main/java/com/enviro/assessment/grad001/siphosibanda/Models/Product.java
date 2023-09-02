package com.enviro.assessment.grad001.siphosibanda.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @JsonProperty("id")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("investor_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_id")
    private Investor investor;
    @JsonProperty("type")
    @Column(name = "type")
    private String type;
    @JsonProperty("name")
    @Column(name = "name")
    private String name;
    @JsonProperty("balance")
    @Column(name = "balance")
    private BigDecimal balance;

    public String getType() {
        return type;
    }
    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
