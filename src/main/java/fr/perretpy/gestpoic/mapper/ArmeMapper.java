package fr.perretpy.gestpoic.mapper;

import fr.perretpy.gestpoic.dto.arme.CreateArmeDto;
import fr.perretpy.gestpoic.model.Arme;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ArmeMapper implements Mapper<Arme, CreateArmeDto, CreateArmeDto, Arme, Arme> {
    @Override
    public Arme fromCreateDto(CreateArmeDto createDto) {
        Arme arme = new Arme();
        arme.setId(UUID.randomUUID());
        arme.setNom(createDto.nom());
        arme.setType(createDto.type());
        return arme;
    }

    @Override
    public void updateEntity(Arme entity, CreateArmeDto updateDto) {
        entity.setNom(updateDto.nom());
        entity.setType(updateDto.type());
    }

    @Override
    public Arme toDetailDto(Arme entity) {
        return entity;
    }

    @Override
    public Arme toListDto(Arme entity) {
        return entity;
    }
}
