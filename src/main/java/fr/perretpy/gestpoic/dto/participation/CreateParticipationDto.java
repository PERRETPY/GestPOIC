package fr.perretpy.gestpoic.dto.participation;

import java.io.Serializable;
import java.util.UUID;

public record CreateParticipationDto(
        UUID seanceId,
        UUID personnelId
) implements Serializable {}
