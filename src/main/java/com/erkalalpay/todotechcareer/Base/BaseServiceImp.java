package com.erkalalpay.todotechcareer.Base;

import java.util.List;

// D: Dto
// E: Entity
public interface BaseServiceImp <D, E> {
    // Model Mapper
    public D entityToDto(E e);

    public E dtoToEntity(D d);

    // C R U D
    // CREATE
    public D create(D d);

    // LIST
    public List<D> list();

    // FIND BY
    public D findById(Long id);

    // UPDATE
    public D update(Long id,D d);

    // DELETE
    public D deleteById(Long id);
}

