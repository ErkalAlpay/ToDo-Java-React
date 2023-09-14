// RCC 
import React, { Component } from 'react'
// ROUTER
import { Navigate, Route, Routes } from 'react-router-dom';
//TODO
import Main from './Main';
import UserRegister from './components/UserRegister';
import UserLogin from './components/UserLogin';

export default class TodoRouter extends Component {

    // Component görünen ismi
    static displayName = "Todo_Router";

    // Constructor
    constructor(props) {
        super(props);
        // STATE
        this.state = {}

    }



    render() {
        return (
            <>
                <Routes>
                    <Route path='/' element={<Main />} />
                    <Route path='/register' element={<UserRegister/>} />
                    <Route path='/login' element={<UserLogin/>} />
                </Routes>
            </>
        )//END RETURN
    }//END RENDER

}
