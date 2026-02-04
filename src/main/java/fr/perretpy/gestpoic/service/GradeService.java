package fr.perretpy.gestpoic.service;

import fr.perretpy.gestpoic.dto.grade.CreateGradeDto;
import fr.perretpy.gestpoic.dto.grade.GradeDetailDto;
import fr.perretpy.gestpoic.dto.grade.GradeListApiDto;
import fr.perretpy.gestpoic.exception.InvalidParameterException;
import fr.perretpy.gestpoic.mapper.GradeMapper;
import fr.perretpy.gestpoic.model.Armee;
import fr.perretpy.gestpoic.model.Grade;
import fr.perretpy.gestpoic.repository.ArmeeRepository;
import fr.perretpy.gestpoic.repository.GradeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GradeService extends CrudServiceImpl<
        Grade,
        CreateGradeDto,
        CreateGradeDto,
        GradeDetailDto,
        GradeListApiDto,
        UUID>{
  private final GradeRepository gradeRepository;
  private final ArmeeRepository armeeRepository;
  private final GradeMapper gradeMapper;

  @Autowired
  public GradeService(GradeRepository gradeRepository, GradeMapper gradeMapper, ArmeeRepository armeeRepository) {
    super(gradeRepository, gradeMapper);

    this.gradeRepository = gradeRepository;
    this.armeeRepository = armeeRepository;
    this.gradeMapper = gradeMapper;
  }

  @Override
  public GradeDetailDto create(CreateGradeDto createGradeDto) {
    if (createGradeDto == null) {
      throw new InvalidParameterException("Create object cannot be null");
    }

    Armee armee = armeeRepository.findById(createGradeDto.armeeId())
            .orElseThrow(() -> new EntityNotFoundException("Armee not found"));

    Grade grade = new Grade();

    grade.setId(UUID.randomUUID());
    grade.setLibelle(createGradeDto.libelle());
    grade.setLibelleCourt(createGradeDto.libelleCourt());
    grade.setNiveau(createGradeDto.niveau());
    grade.setArmee(armee);

    return gradeMapper.toDetailDto(
      gradeRepository.save(grade)
    );
  }

  @Override
  public GradeDetailDto update(UUID id, CreateGradeDto createGradeDto) {
    if (id == null) {
      throw new InvalidParameterException("id cannot be null");
    }
    if (createGradeDto == null) {
      throw new InvalidParameterException("Grade object cannot be null");
    }

    Grade existingGrade = gradeRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Grade id doesn't exist"));

    Armee armee = armeeRepository.findById(createGradeDto.armeeId())
      .orElseThrow(() -> new EntityNotFoundException("Armee not found"));

    existingGrade.setLibelle(createGradeDto.libelle());
    existingGrade.setLibelleCourt(createGradeDto.libelleCourt());
    existingGrade.setNiveau(createGradeDto.niveau());
    existingGrade.setArmee(armee);

    return gradeMapper.toDetailDto(
      gradeRepository.save(existingGrade)
    );
  }

  public Page<GradeListApiDto> getGradeByArmeeId(UUID armeeId, Pageable pageable) {
    Page<Grade> page = this.gradeRepository.getGradesByArmee_Id(armeeId, pageable);
    return page.map(mapper::toListDto);
  }
}
