package fr.perretpy.gestpoic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @Column(name = "id", nullable = false)
    @JsonProperty
    private UUID id;

    @Column(name = "libelle", length = Integer.MAX_VALUE)
    @JsonProperty
    private String libelle;

    @Column(name = "libelle_court", length = Integer.MAX_VALUE)
    @JsonProperty
    private String libelleCourt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "armee_id")
    @JsonProperty
    private Armee armee;

    @Column(name = "niveau", length = Integer.MAX_VALUE)
    @JsonProperty
    private String niveau;

}