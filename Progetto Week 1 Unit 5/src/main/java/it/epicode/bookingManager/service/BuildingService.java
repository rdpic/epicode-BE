package it.epicode.bookingManager.service;

import it.epicode.bookingManager.entity.Building;
import it.epicode.bookingManager.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    public Building save(Building building) {
        return buildingRepository.save(building);
    }

    public Optional<Building> findById(Long id) {
        return buildingRepository.findById(id);
    }

    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    public void deleteById(Long id) {
        buildingRepository.deleteById(id);
    }
}
