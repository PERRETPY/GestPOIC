package fr.perretpy.gestpoic.dto.qualification;

import java.io.Serializable;

public record CreateQualificationDto(
        String libelle,
        Long dureeValidite
) implements Serializable {}
