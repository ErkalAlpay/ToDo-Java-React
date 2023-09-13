package com.erkalalpay.todotechcareer.Service;

import com.erkalalpay.todotechcareer.Base.BaseServiceImp;
import com.erkalalpay.todotechcareer.Configuration.BeanConfig;
import com.erkalalpay.todotechcareer.Model.Dto.LoginResponse;
import com.erkalalpay.todotechcareer.Model.Dto.UserDTO;
import com.erkalalpay.todotechcareer.Model.Entity.User;
import com.erkalalpay.todotechcareer.Model.Request.LoginRequest;
import com.erkalalpay.todotechcareer.Model.Request.RegisterFormRequest;
import com.erkalalpay.todotechcareer.Repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public LoginResponse login(LoginRequest loginRequest){
        if(findByEmailForDuplacite(loginRequest.getEmail())){
            User user = findByEmail(loginRequest.getEmail());
            LoginResponse loginResponse = new LoginResponse(null);
            if(beanConfig.bCryptPasswordEncoder().matches(loginRequest.getPassword(), user.getPassword())){
            loginResponse.setToken(jwtTokenService.generateToken(loginRequest.getEmail()));
            } else throw new UsernameNotFoundException("Kullanıcı adı veya şifre hatalı");
            return loginResponse;
        }else throw new UsernameNotFoundException("Böyle bir kullanıcı bulunmamaktadır");
    }
    public List todoList(String token){
        User user = userRepository.findByUseremail(jwtTokenService.getTokenMail(token));
        return user.getTodoList();
    }


    //Get User by email
    public User findByEmail(String email){
        return userRepository.findByUseremail(email);
    }

    //Checking users email in database for existing
    public boolean findByEmailForDuplacite(String email){
        if (findByEmail(email).getUseremail().equals(email)){
            System.out.println("Bu email adresi daha önce kayıt olmuş");
            return true; //this email is existed
        }else return false; //this email is not existed
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
