package fr.perretpy.gestpoic.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CrudService<E, C, U, D, L, ID> {
    D create(C dto);
    D update(ID id, U dto);
    void delete(ID id);
    Optional<D> getById(ID id);
    Page<L> getAll(Pageable pageable);
}