package fr.perretpy.gestpoic.repository;

import fr.perretpy.gestpoic.model.Grade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GradeRepository extends JpaRepository<Grade, UUID> {
    Page<Grade> getGradesByArmee_Id(UUID armeeId, Pageable pageable);
}
