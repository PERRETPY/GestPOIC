package fr.perretpy.gestpoic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "seance")
public class Seance {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "perception_stande_at")
    private LocalDate perceptionStandeAt;

    @Column(name = "nettoyage_on")
    private OffsetDateTime nettoyageOn;

    @Column(name = "note_service", length = Integer.MAX_VALUE)
    private String noteService;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "date_debut")
    private Instant dateDebut;

    @Column(name = "date_fin")
    private Instant dateFin;

}