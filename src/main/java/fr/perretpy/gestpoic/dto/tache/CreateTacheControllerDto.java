package fr.perretpy.gestpoic.dto.tache;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public record CreateTacheControllerDto(
    UUID seanceId,
    String libelle,
    LocalDate echeanceAt
) implements Serializable {}
