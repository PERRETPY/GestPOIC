package fr.perretpy.gestpoic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "personnel")
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @Column(name = "nom", length = Integer.MAX_VALUE)
    private String nom;

    @Column(name = "prenom", length = Integer.MAX_VALUE)
    private String prenom;

}
