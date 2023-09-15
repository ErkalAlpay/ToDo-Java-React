package com.erkalalpay.todotechcareer.Service;


import com.erkalalpay.todotechcareer.Configuration.BeanConfig;
import com.erkalalpay.todotechcareer.Helper.MailHelper;
import com.erkalalpay.todotechcareer.Model.Dto.LoginResponse;
import com.erkalalpay.todotechcareer.Model.Dto.UserDTO;
import com.erkalalpay.todotechcareer.Model.Entity.User;
import com.erkalalpay.todotechcareer.Model.Request.LoginRequest;
import com.erkalalpay.todotechcareer.Model.Request.RegisterFormRequest;
import com.erkalalpay.todotechcareer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {

    //Calls
    @Autowired
    private BeanConfig beanConfig;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private MailHelper mailHelper;

    //Functions
    public String create(RegisterFormRequest request) {
        User user = new User();
        user.setUseremail(request.getEmail());
        user.setPassword(request.getPassword());
        String bcryptedPassword = beanConfig.bCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(bcryptedPassword);
        userRepository.save(user);
        //mailHelper.serviceRegister(request.getEmail());
        return jwtTokenService.generateToken(request.getEmail());
    }

    

    public LoginResponse login(LoginRequest loginRequest){
        if(!findByEmailForExisting(loginRequest.getEmail())){
            User user = findByEmail(loginRequest.getEmail());
            LoginResponse loginResponse = new LoginResponse(null);
            if(beanConfig.bCryptPasswordEncoder().matches(loginRequest.getPassword(), user.getPassword())){
            loginResponse.setToken(jwtTokenService.generateToken(loginRequest.getEmail()));
            user.setIsLogged(true);
            userRepository.save(user);
            } else System.out.println("Kullanıcı adı veya şifre hatalı");
            return loginResponse;
        }else System.out.println("Böyle bir kullanıcı bulunmamaktadır");
        return null;
    }
    public List todoList(String token){
        User user = userRepository.findByUseremail(jwtTokenService.getTokenMail(token));
        return user.getTodoList();
    }


    //Get User by email
    public User findByEmail(String email){
        User user =userRepository.findByUseremail(email);
        return user;
    }

    //Checking users email in database for existing
    public boolean findByEmailForExisting(String email){
        if (findByEmail(email) == null){
            return true; //this email is not existed
        }else System.out.println("Böyle bir mail adresi databasede bulunmaktadır");
        return false; //this email is existed
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
