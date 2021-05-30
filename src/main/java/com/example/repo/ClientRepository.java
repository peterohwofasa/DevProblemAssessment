package com.example.repo;

import com.example.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,String>, JpaSpecificationExecutor<Client> {

    Optional<Client> findByMobileNumberAndIdNumber(String mobileNumber, String idNumber);




}
