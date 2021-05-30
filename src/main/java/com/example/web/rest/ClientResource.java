package com.example.web.rest;

import com.example.exceptions.IdNumberExistException;
import com.example.domain.Client;
import com.example.domain.ClientSpecifications;
import com.example.repo.ClientRepository;
import com.example.util.IDNumberParser;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api")
@Transactional
public class ClientResource {

    private final ClientRepository clientRepository;
    private final IDNumberParser idNumberParser;
    private static final String ENTITY_NAME = "client";
    private final Logger log = LoggerFactory.getLogger(ClientResource.class);


    @Autowired
    public ClientResource(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        this.idNumberParser = new IDNumberParser();
    }

    /**
     * {@code POST  /clients} : Create a new client.
     *
     * @param client the client to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new client, or with status {@code 400 (Bad Request)} if t>
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) throws URISyntaxException {
        log.debug("REST request to save Blog : {}", client);

        Optional<Client> all = clientRepository.findByMobileNumberAndIdNumber(client.getMobileNumber(), client.getIdNumber());

        if(all.isPresent()) throw new IdNumberExistException("ID number or phone number exist: " + client.getIdNumber() + ":" + client.getMobileNumber());

        Client result = clientRepository.save(client);
        return ResponseEntity.created(new URI("/api/clients/" + result.getIdNumber()))
                .headers(HeaderUtil.createEntityCreationAlert("dev problem", true, ENTITY_NAME, result.getIdNumber()))
                .body(result);
    }

    /**
     * {@code GET  /clients} : get all the clients.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of clients in body.
     */
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        log.debug("REST request to get all clients");
        return clientRepository.findAll();
    }

    /**
     * {@code GET  /clients/:id} : get the "id" client.
     *
     * @param search the id of the client to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the client,
     * or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/client/{search}")
    public ResponseEntity<Client> getClient(@PathVariable String search) {
        log.debug("REST request to get Client : {}", search);
        Optional<Client> client = clientRepository.findById(search);


        return ResponseUtil.wrapOrNotFound(client);

    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Client> search(
            @RequestParam(value = "idNumber", required = false) String idNumber,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "mobileNumber", required = false) String mobileNumber) {

        if (idNumber == null && firstName == null && mobileNumber == null) return clientRepository.findAll();

        List<Client> clients = clientRepository.findAll(Specification.where(ClientSpecifications.idNumberLike(idNumber)).
              and(ClientSpecifications.firstnameLike(firstName)).and(ClientSpecifications.mobileNumberLike(mobileNumber)));


           if(clients.isEmpty()) new RuntimeException("No search result");

        return clients;
    }



}
