package fr.perretpy.gestpoic.dto.participationQualification;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public record CreateParticipationQualificationDto(
  UUID participationId,
  UUID qualificationId,
  UUID armeId,
  Boolean isValidate,
  LocalDate date
) implements Serializable {}
