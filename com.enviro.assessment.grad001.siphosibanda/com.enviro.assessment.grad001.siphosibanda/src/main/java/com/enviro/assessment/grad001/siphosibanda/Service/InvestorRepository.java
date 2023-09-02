package com.enviro.assessment.grad001.siphosibanda.Service;

import com.enviro.assessment.grad001.siphosibanda.Models.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
    // Add any custom query methods if needed
}
