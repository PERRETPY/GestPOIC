package fr.perretpy.gestpoic.repository;

import fr.perretpy.gestpoic.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QualificationRepository extends JpaRepository<Qualification, UUID> {
}
