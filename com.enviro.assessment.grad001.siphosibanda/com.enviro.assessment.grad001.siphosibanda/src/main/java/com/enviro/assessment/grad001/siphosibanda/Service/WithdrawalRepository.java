package com.enviro.assessment.grad001.siphosibanda.Service;

import com.enviro.assessment.grad001.siphosibanda.Models.WithdrawalNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalRepository extends JpaRepository<WithdrawalNotice, Long> {

}
