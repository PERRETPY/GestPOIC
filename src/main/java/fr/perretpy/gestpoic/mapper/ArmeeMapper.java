package fr.perretpy.gestpoic.mapper;

import fr.perretpy.gestpoic.dto.armee.CreateArmeeDto;
import fr.perretpy.gestpoic.model.Armee;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ArmeeMapper implements Mapper<Armee, CreateArmeeDto, CreateArmeeDto, Armee, Armee> {
    @Override
    public Armee fromCreateDto(CreateArmeeDto createDto) {
        Armee armee = new Armee();
        armee.setId(UUID.randomUUID());
        armee.setLibelle(createDto.libelle());
        return armee;
    }

    @Override
    public void updateEntity(Armee entity, CreateArmeeDto updateDto) {
        entity.setLibelle(updateDto.libelle());
    }

    @Override
    public Armee toDetailDto(Armee entity) {
        return entity;
    }

    @Override
    public Armee toListDto(Armee entity) {
        return entity;
    }
}
