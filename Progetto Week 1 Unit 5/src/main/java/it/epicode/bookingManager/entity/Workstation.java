package it.epicode.bookingManager.entity;

import it.epicode.bookingManager.enums.WorkstationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workstations")
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String description;
    @Enumerated(EnumType.STRING)
    private WorkstationType workstationType;
    private int maxOccupants;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

}