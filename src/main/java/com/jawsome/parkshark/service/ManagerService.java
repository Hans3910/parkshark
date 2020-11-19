package com.jawsome.parkshark.service;

import com.jawsome.parkshark.domain.exceptions.NotAnManagerException;
import com.jawsome.parkshark.domain.instances.people.Manager;
import com.jawsome.parkshark.domain.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
@Service
public class ManagerService {
    private ManagerRepository managerRepository;
    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Collection<Manager> getAll() {
        return managerRepository.getAll();
    }

    public void checkAdminId(@RequestParam(required = false) Integer managerId) throws NotAnManagerException {
        if (managerId == 0 || !managerRepository.getManagers().containsKey(managerId)){
            throw new NotAnManagerException("Not A Manager");
        }
    }
}
