package fr.perretpy.gestpoic.repository;

import fr.perretpy.gestpoic.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonnelRepository extends JpaRepository<Personnel, UUID> {
}

