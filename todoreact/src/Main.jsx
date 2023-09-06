import React, { Component } from 'react'

import TodoList from './components/TodoList'
import TodoCreate from './components/TodoCreate'

export default class  extends Component {
  render() {
    return (
        <>

       <TodoCreate/>

  

       <TodoList/>

        

        </>
    )
  }
}


