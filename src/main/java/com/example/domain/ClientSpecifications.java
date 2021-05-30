package com.example.domain;

import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public class ClientSpecifications {

    public static Specification<Client> idNumberLike(String idNumber) {
        return (client, cq, cb) -> Optional.ofNullable(idNumber).map(b -> cb.equal(client.get("idNumber"), b)).orElse(null);
    }

    public static Specification<Client> firstnameLike(String firstName) {
        return (client, cq, cb) -> Optional.ofNullable(firstName).map(f -> cb.like(client.get("firstName"), "%" + f + "%")).orElse(null);
    }

    public static Specification<Client> mobileNumberLike(String mobileNumber) {
        return (client, cq, cb) -> Optional.ofNullable(mobileNumber).map(s -> cb.like(client.get("mobileNumber"), "%" + s + "%")).orElse(null);
    }
}
