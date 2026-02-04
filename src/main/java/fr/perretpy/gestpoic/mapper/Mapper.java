package fr.perretpy.gestpoic.mapper;

public interface Mapper<E, C, U, D, L> {
    E fromCreateDto(C createDto);
    void updateEntity(E entity, U updateDto);
    D toDetailDto(E entity);
    L toListDto(E entity);
}
