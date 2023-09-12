package com.erkalalpay.todotechcareer.Service;

import com.erkalalpay.todotechcareer.Base.BaseServiceImp;
import com.erkalalpay.todotechcareer.Configuration.BeanConfig;
import com.erkalalpay.todotechcareer.Model.Dto.TodoDTO;
import com.erkalalpay.todotechcareer.Model.Dto.UserDTO;
import com.erkalalpay.todotechcareer.Model.Entity.User;
import com.erkalalpay.todotechcareer.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService implements BaseServiceImp <UserDTO, User> {

    //Calls
    private BeanConfig beanConfig;

    private UserRepository userRepository;

    //Functions
    @Override
    public UserDTO entityToDto(User user) {
        UserDTO userDTO = beanConfig.modelMapperBean().map(user, UserDTO.class);
        return userDTO;
    }
    @Override
    public User dtoToEntity(UserDTO userDTO) {
        User user = beanConfig.modelMapperBean().map(userDTO, User.class);
        return user;
    }
    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = beanConfig.modelMapperBean().map(userDTO, User.class);
        String bcryptedPassword = beanConfig.bCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(bcryptedPassword);
        userRepository.save(user);
        return null;
    }
    @Override
    public List list() {
        return null;
    }
    public User getUser (String email){
        return userRepository.findByUseremail(email);
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
