import React, { Component } from 'react'

import TodoList from './components/TodoList'
import TodoCreate from './components/TodoCreate'
import TodoUpdate from './components/TodoUpdate'

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


