package fr.perretpy.gestpoic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tache")
public class Tache {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seance_id")
    private Seance seance;

    @Column(name = "libelle", length = Integer.MAX_VALUE)
    private String libelle;

    @Column(name = "echeance_at")
    private LocalDate echeanceAt;

    @Column(name = "statut")
    private TacheStatut statut;

}