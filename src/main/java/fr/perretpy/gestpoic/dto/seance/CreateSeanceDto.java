package fr.perretpy.gestpoic.dto.seance;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public record CreateSeanceDto(
    LocalDate perceptionStandAt,
    OffsetDateTime nettoyageAt,
    String noteService,
    String description,
    Instant dateDebut,
    Instant dateFin
) implements Serializable {}
