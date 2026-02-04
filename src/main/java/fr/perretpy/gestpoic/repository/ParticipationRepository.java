package fr.perretpy.gestpoic.repository;

import fr.perretpy.gestpoic.model.Participation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParticipationRepository extends JpaRepository<Participation, UUID> {
    Page<Participation> getParticipationsBySeance_Id(UUID seanceId, Pageable pageable);
}
