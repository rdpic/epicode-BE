package it.epicode.bookingManager.service;

import it.epicode.bookingManager.entity.Workstation;
import it.epicode.bookingManager.enums.WorkstationType;
import it.epicode.bookingManager.repository.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkstationService {
    @Autowired
    private WorkstationRepository workstationRepository;

    public Workstation save(Workstation workstation) {
        return workstationRepository.save(workstation);
    }

    public Optional<Workstation> findById(Long id) {
        return workstationRepository.findById(id);
    }

    public List<Workstation> findAll() {
        return workstationRepository.findAll();
    }

    public void deleteById(Long id) {
        workstationRepository.deleteById(id);
    }

    public List<Workstation> findByTypeAndCity(WorkstationType type, String city) {
        return workstationRepository.findByTypeAndBuilding_City(type, city);
    }
}
