package fr.perretpy.gestpoic.dto.personnel;

import java.io.Serializable;
import java.util.UUID;

public record PersonnelListApiDto(
  UUID id,
  String grade,
  String nom,
  String prenom
) implements Serializable {}
