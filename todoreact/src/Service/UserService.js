import axios from "axios";

class UserService {


    // @PostMapping("http://localhost:8080/user/register")
    // public void userRegister(@RequestBody RegisterFormRequest request) {
    //     if (userService.findByEmailForExisting(request.getEmail())) {
    //     userService.create(request);
    //     System.out.println("Kullanıcı başarıyla kayıt oldu");
    //     }else System.out.println("Hata oluştu, tekrar deneyiniz");
    // }

    userRegister(request){

       return axios.post(`http://localhost:8080/user/register`,request);

    }


    // @PostMapping("http://localhost:8080/user/login")
    // public LoginResponse userLogin (@RequestBody LoginRequest loginRequest){
    //     LoginResponse loginResponse = userService.login(loginRequest);
    //     return loginResponse;
    // }

    userLogin(request){
        return axios.post(`http://localhost:8080/user/login`,request);
    }


}
export default UserService;
