package fr.perretpy.gestpoic.mapper;

import fr.perretpy.gestpoic.dto.grade.CreateGradeDto;
import fr.perretpy.gestpoic.dto.grade.GradeDetailDto;
import fr.perretpy.gestpoic.dto.grade.GradeListApiDto;
import fr.perretpy.gestpoic.model.Grade;
import org.springframework.stereotype.Component;

@Component
public class GradeMapper implements Mapper<Grade, CreateGradeDto, CreateGradeDto, GradeDetailDto, GradeListApiDto> {
  @Override
  public Grade fromCreateDto(CreateGradeDto createDto) {
    return null;
  }

  @Override
  public void updateEntity(Grade entity, CreateGradeDto updateDto) {

  }

  @Override
  public GradeDetailDto toDetailDto(Grade entity) {
    return new GradeDetailDto(entity.getId(), entity.getLibelle(), entity.getLibelleCourt(), entity.getArmee().getId(), entity.getNiveau());
  }

  @Override
  public GradeListApiDto toListDto(Grade entity) {
    return new GradeListApiDto(entity.getId(), entity.getLibelle(), entity.getLibelleCourt(), entity.getArmee().getLibelle(), entity.getNiveau());
  }
}
