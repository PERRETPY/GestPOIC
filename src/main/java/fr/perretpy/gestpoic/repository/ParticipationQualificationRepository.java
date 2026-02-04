package fr.perretpy.gestpoic.repository;

import fr.perretpy.gestpoic.model.ParticipationQualification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParticipationQualificationRepository extends JpaRepository<ParticipationQualification, UUID> {
}
