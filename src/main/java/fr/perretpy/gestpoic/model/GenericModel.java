package fr.perretpy.gestpoic.model;

public interface GenericModel<T, ID> {
    ID getId();
    void setId(ID id);
}
