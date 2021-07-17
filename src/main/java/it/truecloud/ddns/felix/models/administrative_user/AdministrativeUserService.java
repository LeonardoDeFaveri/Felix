package it.truecloud.ddns.felix.models.administrative_user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class AdministrativeUserService {
    @Autowired
    private final AdministrativeUserRepository administrativeUserRepository;

    public AdministrativeUserService(AdministrativeUserRepository administrativeUserRepository) {
        this.administrativeUserRepository = administrativeUserRepository;
    }

    /**
     * Retrieves all the administrative users of the system.
     * @return list of administrative users
     */
    public List<AdministrativeUser> getUsers() {
        return administrativeUserRepository.findAll();
    }
}