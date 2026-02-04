package fr.perretpy.gestpoic.service;

import fr.perretpy.gestpoic.dto.tache.*;
import fr.perretpy.gestpoic.exception.InvalidParameterException;
import fr.perretpy.gestpoic.mapper.TacheMapper;
import fr.perretpy.gestpoic.model.*;
import fr.perretpy.gestpoic.repository.SeanceRepository;
import fr.perretpy.gestpoic.repository.TacheRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TacheService extends CrudServiceImpl<
        Tache,
        CreateTacheServiceDto,
        UpdateTacheDto,
        TacheDetailDto,
        TacheListApiDto,
        UUID>{

  final SeanceRepository seanceRepository;

  @Autowired
  public TacheService(TacheRepository tacheRepository, TacheMapper tacheMapper, SeanceRepository seanceRepository) {
    super(tacheRepository, tacheMapper);
    this.seanceRepository = seanceRepository;
  }

  public TacheDetailDto create(CreateTacheControllerDto createTacheControllerDto) {
    if (createTacheControllerDto == null) {
      throw new InvalidParameterException("Create object cannot be null");
    }

    Seance seance = seanceRepository.findById(createTacheControllerDto.seanceId())
            .orElseThrow(() -> new EntityNotFoundException("Seance not found with id " + createTacheControllerDto.seanceId()));

    Tache tache = new Tache();
    tache.setId(UUID.randomUUID());
    tache.setSeance(seance);
    tache.setLibelle(createTacheControllerDto.libelle());
    tache.setEcheanceAt(createTacheControllerDto.echeanceAt());
    tache.setStatut(TacheStatut.CREEE);

    return mapper.toDetailDto(
            repository.save(tache)
    );
  }

}
