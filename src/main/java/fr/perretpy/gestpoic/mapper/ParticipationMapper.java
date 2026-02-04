package fr.perretpy.gestpoic.mapper;

import fr.perretpy.gestpoic.dto.participation.CreateParticipationDto;
import fr.perretpy.gestpoic.model.Participation;
import org.springframework.stereotype.Component;

@Component
public class ParticipationMapper implements Mapper<Participation, CreateParticipationDto, CreateParticipationDto, Participation, Participation> {
  @Override
  public Participation fromCreateDto(CreateParticipationDto createDto) {
    return null;
  }

  @Override
  public void updateEntity(Participation entity, CreateParticipationDto updateDto) {

  }

  @Override
  public Participation toDetailDto(Participation entity) {
    return entity;
  }

  @Override
  public Participation toListDto(Participation entity) {
    return entity;
  }
}
