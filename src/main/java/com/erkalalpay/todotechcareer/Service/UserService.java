package com.erkalalpay.todotechcareer.Service;

import com.erkalalpay.todotechcareer.Base.BaseServiceImp;
import com.erkalalpay.todotechcareer.Configuration.BeanConfig;
import com.erkalalpay.todotechcareer.Model.Dto.UserDTO;
import com.erkalalpay.todotechcareer.Model.Entity.User;
import com.erkalalpay.todotechcareer.Model.Request.RegisterFormRequest;
import com.erkalalpay.todotechcareer.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {

    //Calls
    private BeanConfig beanConfig;

    private UserRepository userRepository;
    private JwtTokenService jwtTokenService;

    //Functions
    public String create(RegisterFormRequest request) {
        User user = beanConfig.modelMapperBean().map(request, User.class);
        String bcryptedPassword = beanConfig.bCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(bcryptedPassword);
        userRepository.save(user);
        return jwtTokenService.generateToken(request.getEmail());
    }
    public List todoList(String token){
        User user = userRepository.findByUseremail(jwtTokenService.getTokenMail(token));
        return user.getTodoList();
    }
    public User findByEmail(String email){
        return userRepository.findByUseremail(email);
    }
    public boolean findByEmailForDuplacite(String email){
        if (findByEmail(email) == null){
            return true;
        }else return false;
    }
    public UserDTO entityToDto(User user) {
        UserDTO userDTO = beanConfig.modelMapperBean().map(user, UserDTO.class);
        return userDTO;
    }
    public User dtoToEntity(UserDTO userDTO) {
        User user = beanConfig.modelMapperBean().map(userDTO, User.class);
        return user;
    }

}
