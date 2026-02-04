package fr.perretpy.gestpoic.mapper;

import fr.perretpy.gestpoic.dto.participationQualification.CreateParticipationQualificationDto;
import fr.perretpy.gestpoic.model.ParticipationQualification;
import org.springframework.stereotype.Component;

@Component
public class ParticipationQualificationMapper implements Mapper<ParticipationQualification, CreateParticipationQualificationDto, CreateParticipationQualificationDto, ParticipationQualification, ParticipationQualification> {
  @Override
  public ParticipationQualification fromCreateDto(CreateParticipationQualificationDto createDto) {
    return null;
  }

  @Override
  public void updateEntity(ParticipationQualification entity, CreateParticipationQualificationDto updateDto) {
  }

  @Override
  public ParticipationQualification toDetailDto(ParticipationQualification entity) {
    return entity;
  }

  @Override
  public ParticipationQualification toListDto(ParticipationQualification entity) {
    return entity;
  }
}
