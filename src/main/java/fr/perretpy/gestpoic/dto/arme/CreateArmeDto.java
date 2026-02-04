package fr.perretpy.gestpoic.dto.arme;

import java.io.Serializable;

public record CreateArmeDto(
        String nom,
        String type
) implements Serializable {}
