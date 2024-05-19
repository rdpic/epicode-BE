package it.epicode.bookingManager.repository;

import it.epicode.bookingManager.entity.Workstation;
import it.epicode.bookingManager.enums.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkstationRepository extends JpaRepository<Workstation, Long> {
    List<Workstation> findByTypeAndBuilding_City(WorkstationType type, String city);
}

