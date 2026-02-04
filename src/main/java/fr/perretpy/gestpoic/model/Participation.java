package fr.perretpy.gestpoic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "participation")
public class Participation {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seance_id")
    private Seance seance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personnel_id")
    private Personnel personnel;

}