package it.truecloud.ddns.felix.models.administrative_user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrativeUserRepository extends JpaRepository<AdministrativeUser, String> {
    AdministrativeUser findByEmail(String email);
}