package fr.perretpy.gestpoic.repository;

import fr.perretpy.gestpoic.model.Armee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArmeeRepository extends JpaRepository<Armee, UUID> {
}
