package com.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client,Integer> {

    @Override
    <S extends Client> S saveAndFlush(S entity);
}
