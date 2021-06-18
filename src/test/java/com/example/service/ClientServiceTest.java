package com.example.service;

import com.example.DemoApplication;
import com.example.domain.Client;
import com.example.domain.ClientSpecifications;
import com.example.repo.ClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Transactional
public class ClientServiceTest {

    private Client clientJohn;

    private Client clientTom;

    @Autowired
    private ClientRepository clientRepository;

    @Before
    public void init() {

        clientJohn = new Client();
        clientJohn.setFirstName("John");
        clientJohn.setLastName("Doe");
        clientJohn.setIdNumber("8002020589089");
        clientJohn.setMobileNumber("0817427002");
        clientRepository.save(clientJohn);

          clientTom = new Client();
          clientTom.setFirstName("Tom");
          clientTom.setLastName("Doe");
          clientTom.setIdNumber("8404216091187");
          clientTom.setMobileNumber("0788713421");
          clientRepository.save(clientTom);

    }
    @Test
    public void givenFirstNameIsPresent() {

        String firstName = "Tom";
        List<Client> results = clientRepository.findAll(Specification.where(ClientSpecifications.firstnameLike(firstName)));
        assertThat(results).isNotEmpty();
    }
    @Test
    public void givenFirstNameIsNotPresent() {

        String firstName = "Peter";
        List<Client> results = clientRepository.findAll(Specification.where(ClientSpecifications.firstnameLike(firstName)));
        assertThat(results).isEmpty();
    }
    @Test
    public void givenIdNumberIsPresent() {

        String idNumber = "8404216091187";
        List<Client> results = clientRepository.findAll(Specification.where(ClientSpecifications.idNumberLike(idNumber)));
        assertThat(results).isNotEmpty();
    }
    @Test
    public void givenIdNumberIsNotPresent() {

        String idNumber = "84042160911875";
        List<Client> results = clientRepository.findAll(Specification.where(ClientSpecifications.idNumberLike(idNumber)));
        assertThat(results).isEmpty();
    }

    @Test
    public void givenMobileNumberIsPresent() {

        String mobileNumber = "0817427002";
        List<Client> results = clientRepository.findAll(Specification.where(ClientSpecifications.mobileNumberLike(mobileNumber)));
        assertThat(results).isNotEmpty();
    }
    @Test
    public void givenMobileNumberIsNotPresent() {

        String mobileNumber = "08174427002";
        List<Client> results = clientRepository.findAll(Specification.where(ClientSpecifications.mobileNumberLike(mobileNumber)));
        assertThat(results).isEmpty();
    }

}
