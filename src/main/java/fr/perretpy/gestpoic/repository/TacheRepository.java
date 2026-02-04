package fr.perretpy.gestpoic.repository;

import fr.perretpy.gestpoic.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TacheRepository extends JpaRepository<Tache, UUID> {
}
