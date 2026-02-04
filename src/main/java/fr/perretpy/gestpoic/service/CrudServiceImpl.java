package fr.perretpy.gestpoic.service;

import fr.perretpy.gestpoic.exception.InvalidParameterException;
import fr.perretpy.gestpoic.mapper.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class CrudServiceImpl<E, C, U, D, L, ID>
        implements CrudService<E, C, U, D, L, ID> {

    protected final JpaRepository<E, ID> repository;
    protected final Mapper<E, C, U, D, L> mapper;

    protected CrudServiceImpl(JpaRepository<E, ID> repository,
                              Mapper<E, C, U, D, L> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<L> getAll(Pageable pageable) {
        Page<E> page = this.repository.findAll(pageable);
        return page.map(mapper::toListDto);
    }

    @Override
    @Transactional
    public D create(C dto) {
        if (dto == null) {
            throw new InvalidParameterException("Create object cannot be null");
        }

        E entity = mapper.fromCreateDto(dto);
        return mapper.toDetailDto(repository.save(entity));
    }

    @Override
    @Transactional
    public D update(ID id, U dto) {
        if (id == null) {
            throw new InvalidParameterException("id cannot be null");
        }
        if (dto == null) {
            throw new InvalidParameterException("Object cannot be null");
        }

        E existingEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        mapper.updateEntity(existingEntity, dto);
        return mapper.toDetailDto(repository.save(existingEntity));
    }

    @Override
    @Transactional
    public void delete(ID id) {
        if (id == null) {
            throw new InvalidParameterException("ID cannot be null");
        }
        if (!repository.existsById(id)) {
          throw new ResourceNotFoundException("Entity not found");
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<D> getById(ID id) {
      if (id == null) {
        throw new InvalidParameterException("ID cannot be null");
      }
      return repository.findById(id).map(mapper::toDetailDto);
    }
}
