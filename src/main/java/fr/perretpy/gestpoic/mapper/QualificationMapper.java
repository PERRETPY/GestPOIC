package fr.perretpy.gestpoic.mapper;

import fr.perretpy.gestpoic.dto.qualification.CreateQualificationDto;
import fr.perretpy.gestpoic.model.Qualification;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class QualificationMapper implements Mapper<Qualification, CreateQualificationDto, CreateQualificationDto, Qualification, Qualification> {
    @Override
    public Qualification fromCreateDto(CreateQualificationDto createDto) {
        Qualification qualification = new Qualification();
        qualification.setId(UUID.randomUUID());
        qualification.setLibelle(createDto.libelle());
        qualification.setDureeValidite(createDto.dureeValidite());
        return qualification;
    }

    @Override
    public void updateEntity(Qualification entity, CreateQualificationDto updateDto) {
        entity.setLibelle(updateDto.libelle());
        entity.setDureeValidite(updateDto.dureeValidite());
    }

    @Override
    public Qualification toDetailDto(Qualification entity) {
        return entity;
    }

    @Override
    public Qualification toListDto(Qualification entity) {
        return entity;
    }
}
