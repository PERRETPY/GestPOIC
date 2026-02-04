package fr.perretpy.gestpoic.dto.grade;

import java.io.Serializable;
import java.util.UUID;

public record GradeListApiDto(
    UUID id,
    String libelle,
    String libelleCourt,
    String armee,
    String niveau

) implements Serializable {}
