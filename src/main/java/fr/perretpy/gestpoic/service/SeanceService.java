package fr.perretpy.gestpoic.service;

import fr.perretpy.gestpoic.dto.seance.CreateSeanceDto;
import fr.perretpy.gestpoic.mapper.SeanceMapper;
import fr.perretpy.gestpoic.model.Seance;
import fr.perretpy.gestpoic.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SeanceService extends CrudServiceImpl<
        Seance,
        CreateSeanceDto,
        CreateSeanceDto,
        Seance,
        Seance,
        UUID
        > {
    @Autowired
    public SeanceService(SeanceRepository seanceRepository, SeanceMapper seanceMapper) {
        super(seanceRepository, seanceMapper);
    }
}
