package fr.perretpy.gestpoic.service;

import fr.perretpy.gestpoic.dto.qualification.CreateQualificationDto;
import fr.perretpy.gestpoic.mapper.QualificationMapper;
import fr.perretpy.gestpoic.model.Qualification;
import fr.perretpy.gestpoic.repository.QualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class QualificationService extends CrudServiceImpl<
        Qualification,
        CreateQualificationDto,
        CreateQualificationDto,
        Qualification,
        Qualification,
        UUID
        > {
    @Autowired
    public QualificationService(QualificationRepository qualificationRepository, QualificationMapper qualificationMapper) {
        super(qualificationRepository, qualificationMapper);
    }
}
