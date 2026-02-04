package fr.perretpy.gestpoic.mapper;

import fr.perretpy.gestpoic.dto.personnel.CreatePersonnelDto;
import fr.perretpy.gestpoic.dto.personnel.PersonnelDetailDto;
import fr.perretpy.gestpoic.dto.personnel.PersonnelListApiDto;
import fr.perretpy.gestpoic.model.Personnel;
import org.springframework.stereotype.Component;

@Component
public class PersonnelMapper implements Mapper<Personnel, CreatePersonnelDto, CreatePersonnelDto, PersonnelDetailDto, PersonnelListApiDto> {
  @Override
  public Personnel fromCreateDto(CreatePersonnelDto createDto) {
    return null;
  }

  @Override
  public void updateEntity(Personnel entity, CreatePersonnelDto updateDto) {

  }

  @Override
  public PersonnelDetailDto toDetailDto(Personnel entity) {
    return new PersonnelDetailDto(entity.getId(), entity.getGrade().getId(), entity.getNom(), entity.getPrenom());
  }

  @Override
  public PersonnelListApiDto toListDto(Personnel entity) {
    return new PersonnelListApiDto(entity.getId(), entity.getGrade().getLibelleCourt(), entity.getNom(), entity.getPrenom());
  }
}
