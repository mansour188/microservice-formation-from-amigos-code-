package com.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FraudCheckRepo extends JpaRepository<FraudCheckHistory,Integer> {
}
