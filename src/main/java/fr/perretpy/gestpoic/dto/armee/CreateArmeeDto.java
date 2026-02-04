package fr.perretpy.gestpoic.dto.armee;

import java.io.Serializable;

public record CreateArmeeDto(
        String libelle
) implements Serializable {}
