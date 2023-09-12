package com.erkalalpay.todotechcareer.Service;

import com.erkalalpay.todotechcareer.Base.BaseServiceImp;
import com.erkalalpay.todotechcareer.Model.Dto.UserDTO;
import com.erkalalpay.todotechcareer.Model.Entity.User;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService implements BaseServiceImp <UserDTO, User> {
    @Override
    public UserDTO entityToDto(User user) {
        return null;
    }

    @Override
    public User dtoToEntity(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        return null;
    }

    @Override
    public List list() {
        return null;
    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO deleteById(Long id) {
        return null;
    }
}
