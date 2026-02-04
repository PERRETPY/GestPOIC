package fr.perretpy.gestpoic.repository;

import fr.perretpy.gestpoic.model.Arme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArmeRepository extends JpaRepository<Arme, UUID> {
}
