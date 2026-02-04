package fr.perretpy.gestpoic.controller;

import fr.perretpy.gestpoic.exception.ResourceNotFoundException;
import fr.perretpy.gestpoic.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class CrudController<E, C, U, D, L, ID> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    public final String requestMapping;

    protected final CrudService<E, C, U, D, L, ID> service;

    protected CrudController(CrudService<E, C, U, D, L, ID> service) {
        this.service = service;
        Class<?> controllerClass = this.getClass();
        if (controllerClass.isAnnotationPresent(RequestMapping.class)) {
            RequestMapping mapping = controllerClass.getAnnotation(RequestMapping.class);
            String[] paths = mapping.value();
            if (paths.length > 0) {
                this.requestMapping = paths[0];
            }else {
                this.requestMapping = "no request mapping";
            }
        }else {
            this.requestMapping = "no request mapping";
        }
    }

    @PostMapping
    public ResponseEntity<D> create(@RequestBody C dto) {
        logger.info("POST request on {} with parameters: {}", this.requestMapping, dto);

        D savedEntity = this.service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable ID id, @RequestBody U dto) {
        logger.info("PUT request on {}/{} with parameters: {}", this.requestMapping, id, dto);
        D updatedEntity = this.service.update(id, dto);
        return ResponseEntity.ok(updatedEntity);
    }

    @GetMapping
    public ResponseEntity<Page<L>> getAll(Pageable pageable) {
        logger.info("GET request on {} with parameters: {}", this.requestMapping, pageable);
        Page<L> page = this.service.getAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable ID id) {
        logger.info("GET request on {}/{}", this.requestMapping, id);
        D entity = this.service.getById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        logger.info("DELETE request on {}/{}", this.requestMapping, id);
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

