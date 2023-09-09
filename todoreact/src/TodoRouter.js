// RCC 
import React, { Component } from 'react'
// ROUTER
import { Navigate, Route, Routes } from 'react-router-dom';

//TODO
import TodoList from './components/TodoList';
import TodoCreate from './components/TodoCreate';
import TodoUpdate from './components/TodoUpdate';
import Main from './Main';

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

                    {/* TODO UPDATE  */}
                    <Route path='/todo/update' element = {<TodoUpdate/>} />




                </Routes>
            </>
        )//END RETURN
    }//END RENDER

}
