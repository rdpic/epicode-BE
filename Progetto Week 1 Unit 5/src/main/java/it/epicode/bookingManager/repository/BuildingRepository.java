package it.epicode.bookingManager.repository;

import it.epicode.bookingManager.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}
