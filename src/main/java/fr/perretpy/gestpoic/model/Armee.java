package fr.perretpy.gestpoic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "armee")
public class Armee {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "libelle", length = Integer.MAX_VALUE)
    @JsonProperty
    private String libelle;

}