package com.jawsome.parkshark.domain.repositories;

import com.jawsome.parkshark.domain.exceptions.NotAnManagerException;
import com.jawsome.parkshark.domain.instances.people.Email;
import com.jawsome.parkshark.domain.instances.people.Manager;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ManagerRepository {
    private Map<Integer, Manager> managers = new HashMap<>();

    public ManagerRepository() {
        addFirstManager();
    }

    private void addFirstManager() {
        Manager manager = new Manager(1, "011647585", new Email());
        managers.put(manager.getId(), manager);
    }

    public Map<Integer, Manager> getManagers() {
        return managers;
    }

    public Collection<Manager> getAll() {
        return new ArrayList<>(managers.values());
    }
}