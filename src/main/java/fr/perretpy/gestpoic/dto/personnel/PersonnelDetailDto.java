package fr.perretpy.gestpoic.dto.personnel;

import java.io.Serializable;
import java.util.UUID;

public record PersonnelDetailDto(
  UUID id,
  UUID gradeId,
  String nom,
  String prenom
) implements Serializable {}
