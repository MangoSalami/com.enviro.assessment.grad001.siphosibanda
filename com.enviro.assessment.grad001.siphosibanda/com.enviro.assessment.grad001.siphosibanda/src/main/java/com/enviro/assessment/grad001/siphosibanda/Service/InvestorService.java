package com.enviro.assessment.grad001.siphosibanda.Service;

import com.enviro.assessment.grad001.siphosibanda.Models.Investor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestorService {
    @Autowired
    private final InvestorRepository investorRepository;

    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public Investor getInvestorById(Long id) {
        return investorRepository.findById(id).orElse(null);
    }
    @Transactional
    public Investor addInvestor(Investor investor) {

        return investorRepository.save(investor);
    }
    // Other methods...
}