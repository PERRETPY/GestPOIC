package fr.perretpy.gestpoic.dto.tache;

import fr.perretpy.gestpoic.model.TacheStatut;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public record TacheListApiDto(
    UUID id,
    UUID seanceId,
    String libelle,
    LocalDate echeanceAt,
    TacheStatut statut

) implements Serializable {}
