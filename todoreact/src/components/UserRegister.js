import React, { useState, useEffect } from 'react';

export default function UserRegister() {
    //STATE
    const [registerEmail, setRegisterEmail] = useState("");
    const [registerPassword, setRegisterPassword] = useState("");
    const [registerPassword2, setRegisterPassword2] = useState("");
    const [error, setError] = useState();

    useEffect(() => {
        setError(undefined);
    }, [registerEmail], [registerPassword], [registerPassword2]);

    const registerUser = async (event) => {
        event.preventDefault();

        // Creating User
        if (registerPassword == registerPassword2) {
            const newUser = {
                "email": registerEmail,
                "password": registerPassword
            };
            console.log(newUser);

            //SERVICE
            try {
                //const response = await TodoService.saveTodo(newTodo);
                // Burada response ile ne yapmak istediğinizi ekleyebilirsiniz
               // window.location.assign("http://localhost:3000/");
            } catch (err) {
                setError(err.response.data.validationErrors);
            }
        } else console.log("Girdiğiniz şifrelet aynı değil!");

    }


    // CHANGE
    const emailOnChange = (event) => {
        const { registerEmail, value } = event.target;
        // onChange
        setRegisterEmail(value)
        
    }

    const passwordOnChange = (event) => {
        const { registerPassword, value } = event.target;
        // onChange
        setRegisterPassword(value)
    }

    const password2OnChange = (event) => {
        const { registerPassword2, value } = event.target;
        // onChange
        setRegisterPassword2(value)
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

                                        <p className="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

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

                                            <div className="d-flex flex-row align-items-center mb-4">
                                                <i className="fas fa-key fa-lg me-3 fa-fw"></i>
                                                <div className="form-outline flex-fill mb-0">
                                                    <input type="password" id="form3Example4cd" className="form-control" onChange={password2OnChange} />
                                                    <label className="form-label" htmlFor="form3Example4cd">Repeat your password</label>
                                                </div>
                                            </div>

                                            <div className="form-check d-flex justify-content-center mb-5">
                                                <input className="form-check-input me-2" type="checkbox" value="" id="form2Example3c" />
                                                <label className="form-check-label" htmlFor="form2Example3">
                                                    I agree all statements in <a href="#!">Terms of service</a>
                                                </label>
                                            </div>

                                            <div className="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                                <button type="button" className="btn btn-primary btn-lg" onClick={registerUser}>Register</button>
                                            </div>
                                            <p className="text-center text-muted mt-5 mb-0">Have already an account? <a href="http://localhost:3000/login"
                                                className="fw-bold text-body"><u>Login here</u></a></p>

                                        </form>

                                    </div>
                                    <div className="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
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
