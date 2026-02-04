package fr.perretpy.gestpoic.controller;

import fr.perretpy.gestpoic.dto.participation.CreateParticipationDto;
import fr.perretpy.gestpoic.dto.participation.ParticipationBySeanceDto;
import fr.perretpy.gestpoic.model.Participation;
import fr.perretpy.gestpoic.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/participations")
public class ParticipationController extends CrudController<
        Participation,
        CreateParticipationDto,
        CreateParticipationDto,
        Participation,
        Participation,
        UUID>{

    ParticipationService participationService;
    @Autowired
    public ParticipationController(ParticipationService participationService) {
        super(participationService);
        this.participationService = participationService;
    }

    @GetMapping("/seance/{seanceId}")
    public ResponseEntity<Page<ParticipationBySeanceDto>> getBySeanceId(@PathVariable UUID seanceId, Pageable pageable) {
        logger.info("GET request on {} with parameters: {}", this.requestMapping, pageable);
        Page<ParticipationBySeanceDto> page = this.participationService.getBySeanceId(seanceId, pageable);
        return ResponseEntity.ok(page);
    }
}
