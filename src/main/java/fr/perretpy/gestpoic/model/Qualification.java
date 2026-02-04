package fr.perretpy.gestpoic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "qualification")
public class Qualification {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "libelle", length = Integer.MAX_VALUE)
    private String libelle;

    @Column(name = "duree_validite")
    private Long dureeValidite;

}