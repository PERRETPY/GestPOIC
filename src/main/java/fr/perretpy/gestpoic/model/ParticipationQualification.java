package fr.perretpy.gestpoic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "participation_qualification")
public class ParticipationQualification {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "participation_id", nullable = false)
    private Participation participation;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "qualification_id", nullable = false)
    private Qualification qualification;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "arme_id", nullable = false)
    private Arme arme;

    @Column(name = "is_validate")
    private Boolean isValidate;

    @Column(name = "date")
    private LocalDate date;

}