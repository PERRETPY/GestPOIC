package fr.perretpy.gestpoic.dto.tache;

import fr.perretpy.gestpoic.model.TacheStatut;

import java.io.Serializable;
import java.time.LocalDate;

public record UpdateTacheDto(
    String libelle,
    LocalDate echeanceAt,
    TacheStatut statut
) implements Serializable {}
