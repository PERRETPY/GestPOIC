package fr.perretpy.gestpoic.service;

import fr.perretpy.gestpoic.dto.participationQualification.CreateParticipationQualificationDto;
import fr.perretpy.gestpoic.exception.InvalidParameterException;
import fr.perretpy.gestpoic.mapper.ParticipationQualificationMapper;
import fr.perretpy.gestpoic.model.*;
import fr.perretpy.gestpoic.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParticipationQualificationService extends CrudServiceImpl<
        ParticipationQualification,
        CreateParticipationQualificationDto,
        CreateParticipationQualificationDto,
        ParticipationQualification,
        ParticipationQualification,
        UUID>{
  private final ParticipationQualificationRepository participationQualificationRepository;
  private final ParticipationRepository participationRepository;
  private final QualificationRepository qualificationRepository;
  private final ArmeRepository armeRepository;

  @Autowired
  public ParticipationQualificationService(ParticipationQualificationRepository participationQualificationRepository, ParticipationQualificationMapper participationQualificationMapper, ParticipationRepository participationRepository, QualificationRepository qualificationRepository, ArmeRepository armeRepository) {
    super(participationQualificationRepository, participationQualificationMapper);

    this.participationQualificationRepository = participationQualificationRepository;
    this.participationRepository = participationRepository;
    this.qualificationRepository = qualificationRepository;
    this.armeRepository = armeRepository;
  }

  @Override
  public ParticipationQualification create(CreateParticipationQualificationDto createParticipationQualificationDto) {
    if (createParticipationQualificationDto == null) {
      throw new InvalidParameterException("Create object cannot be null");
    }

    Participation participation = participationRepository.findById(createParticipationQualificationDto.participationId())
      .orElseThrow(() -> new EntityNotFoundException("Participation not found with id " + createParticipationQualificationDto.participationId()));

    Qualification qualification = qualificationRepository.findById(createParticipationQualificationDto.qualificationId())
            .orElseThrow(() -> new EntityNotFoundException("Qualification not found with id " + createParticipationQualificationDto.qualificationId()));

    Arme arme = armeRepository.findById(createParticipationQualificationDto.armeId())
            .orElseThrow(() -> new EntityNotFoundException("Arme not found with id " + createParticipationQualificationDto.armeId()));

    ParticipationQualification participationQualification = new ParticipationQualification();
    participationQualification.setId(UUID.randomUUID());
    participationQualification.setParticipation(participation);
    participationQualification.setQualification(qualification);
    participationQualification.setArme(arme);
    participationQualification.setIsValidate(createParticipationQualificationDto.isValidate());
    participationQualification.setDate(createParticipationQualificationDto.date());

    return participationQualification;
  }

  @Override
  public ParticipationQualification update(UUID id, CreateParticipationQualificationDto createParticipationQualificationDto) {
    if (id == null) {
      throw new InvalidParameterException("id cannot be null");
    }
    if (createParticipationQualificationDto == null) {
      throw new InvalidParameterException("ParticipationQualification object cannot be null");
    }

    ParticipationQualification existingParticipationQualification = participationQualificationRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("ParticipationQualification id doesn't exist"));

    Participation participation = participationRepository.findById(createParticipationQualificationDto.participationId())
            .orElseThrow(() -> new EntityNotFoundException("Participation not found with id " + createParticipationQualificationDto.participationId()));

    Qualification qualification = qualificationRepository.findById(createParticipationQualificationDto.qualificationId())
            .orElseThrow(() -> new EntityNotFoundException("Qualification not found with id " + createParticipationQualificationDto.qualificationId()));

    Arme arme = armeRepository.findById(createParticipationQualificationDto.armeId())
            .orElseThrow(() -> new EntityNotFoundException("Arme not found with id " + createParticipationQualificationDto.armeId()));

    ParticipationQualification participationQualification = new ParticipationQualification();
    participationQualification.setId(UUID.randomUUID());
    participationQualification.setParticipation(participation);
    participationQualification.setQualification(qualification);
    participationQualification.setArme(arme);
    participationQualification.setIsValidate(createParticipationQualificationDto.isValidate());
    participationQualification.setDate(createParticipationQualificationDto.date());

    return participationQualification;
  }
}
