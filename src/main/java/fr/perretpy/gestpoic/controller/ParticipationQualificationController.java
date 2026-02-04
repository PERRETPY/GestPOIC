package fr.perretpy.gestpoic.controller;

import fr.perretpy.gestpoic.dto.participationQualification.CreateParticipationQualificationDto;
import fr.perretpy.gestpoic.model.ParticipationQualification;
import fr.perretpy.gestpoic.service.ParticipationQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/participationQualifications")
public class ParticipationQualificationController extends CrudController<
        ParticipationQualification,
        CreateParticipationQualificationDto,
        CreateParticipationQualificationDto,
        ParticipationQualification,
        ParticipationQualification,
        UUID>{
    @Autowired
    public ParticipationQualificationController(ParticipationQualificationService participationQualificationService) {
        super(participationQualificationService);
    }
}
