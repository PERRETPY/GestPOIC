package fr.perretpy.gestpoic.service;

import fr.perretpy.gestpoic.dto.participation.CreateParticipationDto;
import fr.perretpy.gestpoic.dto.participation.ParticipationBySeanceDto;
import fr.perretpy.gestpoic.exception.InvalidParameterException;
import fr.perretpy.gestpoic.mapper.ParticipationMapper;
import fr.perretpy.gestpoic.model.Participation;
import fr.perretpy.gestpoic.model.Personnel;
import fr.perretpy.gestpoic.model.Seance;
import fr.perretpy.gestpoic.repository.ParticipationRepository;
import fr.perretpy.gestpoic.repository.PersonnelRepository;
import fr.perretpy.gestpoic.repository.SeanceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParticipationService extends CrudServiceImpl<
        Participation,
        CreateParticipationDto,
        CreateParticipationDto,
        Participation,
        Participation,
        UUID>{
  private final ParticipationRepository participationRepository;
  private final SeanceRepository seanceRepository;
  private final PersonnelRepository personnelRepository;

  @Autowired
  public ParticipationService(ParticipationRepository participationRepository, ParticipationMapper participationMapper, SeanceRepository seanceRepository, PersonnelRepository personnelRepository) {
    super(participationRepository, participationMapper);

    this.participationRepository = participationRepository;
    this.personnelRepository = personnelRepository;
    this.seanceRepository = seanceRepository;
  }

  @Override
  public Participation create(CreateParticipationDto createParticipationDto) {
    if (createParticipationDto == null) {
      throw new InvalidParameterException("Create object cannot be null");
    }

    Seance seance = seanceRepository.findById(createParticipationDto.seanceId())
      .orElseThrow(() -> new EntityNotFoundException("Seance not found with id " + createParticipationDto.seanceId()));

    Personnel personnel = personnelRepository.findById(createParticipationDto.personnelId())
            .orElseThrow(() -> new EntityNotFoundException("Personnel not found with id " + createParticipationDto.personnelId()));

    Participation participation = new Participation();
    participation.setId(UUID.randomUUID());
    participation.setPersonnel(personnel);
    participation.setSeance(seance);

    return participation;
  }

  @Override
  public Participation update(UUID id, CreateParticipationDto createParticipationDto) {
    if (id == null) {
      throw new InvalidParameterException("id cannot be null");
    }
    if (createParticipationDto == null) {
      throw new InvalidParameterException("Participation object cannot be null");
    }

    Participation existingParticipation = participationRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("Participation id doesn't exist"));

    Seance seance = seanceRepository.findById(createParticipationDto.seanceId())
            .orElseThrow(() -> new EntityNotFoundException("Seance not found with id " + createParticipationDto.seanceId()));

    Personnel personnel = personnelRepository.findById(createParticipationDto.personnelId())
            .orElseThrow(() -> new EntityNotFoundException("Personnel not found with id " + createParticipationDto.personnelId()));

    existingParticipation.setPersonnel(personnel);
    existingParticipation.setSeance(seance);

    return existingParticipation;
  }

  public Page<ParticipationBySeanceDto> getBySeanceId(UUID seanceId, Pageable pageable) {
    Page<Participation> page = this.participationRepository.getParticipationsBySeance_Id(seanceId, pageable);

      return page.map(ParticipationBySeanceDto::new);
  }
}
