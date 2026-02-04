package fr.perretpy.gestpoic.service;

import fr.perretpy.gestpoic.dto.personnel.CreatePersonnelDto;
import fr.perretpy.gestpoic.dto.personnel.PersonnelDetailDto;
import fr.perretpy.gestpoic.dto.personnel.PersonnelListApiDto;
import fr.perretpy.gestpoic.exception.InvalidParameterException;
import fr.perretpy.gestpoic.mapper.PersonnelMapper;
import fr.perretpy.gestpoic.model.Grade;
import fr.perretpy.gestpoic.model.Personnel;
import fr.perretpy.gestpoic.repository.GradeRepository;
import fr.perretpy.gestpoic.repository.PersonnelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonnelService extends CrudServiceImpl<
        Personnel,
        CreatePersonnelDto,
        CreatePersonnelDto,
        PersonnelDetailDto,
        PersonnelListApiDto,
        UUID>{
  private final PersonnelRepository personnelRepository;
  private final GradeRepository gradeRepository;

  @Autowired
  public PersonnelService(PersonnelRepository personnelRepository, PersonnelMapper personnelMapper, GradeRepository gradeRepository) {
    super(personnelRepository, personnelMapper);

    this.personnelRepository = personnelRepository;
    this.gradeRepository = gradeRepository;
  }

  @Override
  public PersonnelDetailDto create(CreatePersonnelDto createPersonnelDto) {
    if (createPersonnelDto == null) {
      throw new InvalidParameterException("Create object cannot be null");
    }

    Grade grade = gradeRepository.findById(createPersonnelDto.gradeId())
      .orElseThrow(() -> new EntityNotFoundException("Grade not found with id " + createPersonnelDto.gradeId()));

    Personnel personnel = new Personnel();
    personnel.setId(UUID.randomUUID());
    personnel.setNom(createPersonnelDto.nom());
    personnel.setPrenom(createPersonnelDto.prenom());
    personnel.setGrade(grade);

    return this.mapper.toDetailDto(
      personnelRepository.save(personnel)
    );
  }

  @Override
  public PersonnelDetailDto update(UUID id, CreatePersonnelDto createPersonnelDto) {
    if (id == null) {
      throw new InvalidParameterException("id cannot be null");
    }
    if (createPersonnelDto == null) {
      throw new InvalidParameterException("Personnel object cannot be null");
    }

    Personnel existingPersonnel = personnelRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Personnel id doesn't exist"));

    Grade grade = gradeRepository.findById(createPersonnelDto.gradeId())
      .orElseThrow(() -> new EntityNotFoundException("Grade not found"));

    existingPersonnel.setNom(createPersonnelDto.nom());
    existingPersonnel.setPrenom(createPersonnelDto.prenom());
    existingPersonnel.setGrade(grade);

    return this.mapper.toDetailDto(
      personnelRepository.save(existingPersonnel)
    );
  }
}
