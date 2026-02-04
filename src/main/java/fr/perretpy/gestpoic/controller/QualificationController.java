package fr.perretpy.gestpoic.controller;

import fr.perretpy.gestpoic.dto.qualification.CreateQualificationDto;
import fr.perretpy.gestpoic.model.Qualification;
import fr.perretpy.gestpoic.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/qualifications")
public class QualificationController extends CrudController<
        Qualification,
        CreateQualificationDto,
        CreateQualificationDto,
        Qualification,
        Qualification,
        UUID
        > {
    @Autowired
    public QualificationController(QualificationService qualificationService) {
        super(qualificationService);
    }
}
