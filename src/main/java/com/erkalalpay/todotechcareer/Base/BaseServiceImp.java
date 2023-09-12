package com.erkalalpay.todotechcareer.Base;

import com.erkalalpay.todotechcareer.Model.Dto.UserDTO;
import com.erkalalpay.todotechcareer.Model.Entity.User;

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

    Object entityToDto(User user);

    Object dtoToEntity(UserDTO userDTO);

    Object create(UserDTO userDTO);

    // LIST
    public List<D> list();

    // FIND BY
    public D findById(Long id);

    // UPDATE
    public D update(Long id,D d);

    // DELETE
    public D deleteById(Long id);
}

