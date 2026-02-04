package fr.perretpy.gestpoic.dto.grade;

import java.io.Serializable;
import java.util.UUID;

public record GradeDetailDto (
    UUID id,
    String libelle,
    String libelleCourt,
    UUID armeeId,
    String niveau
) implements Serializable {}
