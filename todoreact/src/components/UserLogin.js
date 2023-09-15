import React, { useState } from 'react'
import UserService from '../Service/UserService';

export default function UserLogin() {

     //STATE
     const [loginEmail, setLoginEmail] = useState("");
     const [loginPassword, setLoginPassword] = useState("");
     const [error, setError] = useState();


    const userService = new UserService();


     const loginUser = async (event) => {
        event.preventDefault();

        // Login Metot
            const request = {
                "email": loginEmail,
                "password": loginPassword
            };
            console.log(request);

            //SERVICE
            try {
                const response = await userService.userLogin(request)
                console.log(response.data);
                localStorage.setItem("user_token", response.data);
            //Burada response ile ne yapmak istediğinizi ekleyebilirsiniz
            if(response.status == 200){
                window.location.assign("http://localhost:3000/");
               }
            } catch (err) {
                setError(err);
            }
    }

    // EVENT LISTENERS
    const emailOnChange = (event) => {
        const { loginEmail, value } = event.target;
        // onChange
        setLoginEmail(value)
        
    }

    const passwordOnChange = (event) => {
        const { loginPassword, value } = event.target;
        // onChange
        setLoginPassword(value)
    }



    return (

        <section className="vh-100" styles="background-color: #eee;">
            <div className="container h-100">
                <div className="row d-flex justify-content-center align-items-center h-100">
                    <div className="col-lg-12 col-xl-11">
                        <div className="card text-black" styles="border-radius: 25px;">
                            <div className="card-body p-md-5">
                                <div className="row justify-content-center">
                                    <div className="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                        <p className="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Login</p>

                                        <form className="mx-1 mx-md-4">

                                            <div className="d-flex flex-row align-items-center mb-4">
                                                <i className="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                                <div className="form-outline flex-fill mb-0">
                                                    <input type="email" id="form3Example3c" className="form-control" onChange={emailOnChange} />
                                                    <label className="form-label" htmlFor="form3Example3c">Your Email</label>
                                                </div>
                                            </div>

                                            <div className="d-flex flex-row align-items-center mb-4">
                                                <i className="fas fa-lock fa-lg me-3 fa-fw"></i>
                                                <div className="form-outline flex-fill mb-0">
                                                    <input type="password" id="form3Example4c" className="form-control" onChange={passwordOnChange} />
                                                    <label className="form-label" htmlFor="form3Example4c">Password</label>
                                                </div>
                                            </div>                    

                                            <div className="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                                <button type="button" className="btn btn-primary btn-lg" onClick={loginUser}>Login</button>
                                            </div>
                                            <p className="text-center text-muted mt-5 mb-0">Don't you have an account yet? <a href="http://localhost:3000/register"
                                                className="fw-bold text-body"><u>Register here</u></a></p>

                                        </form>

                                    </div>
                                    <div className="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                                            className="img-fluid" alt="Sample image" />

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    )//end return
}//end class
