import React, { useEffect, useState } from 'react'
import TodoService from '../Service/TodoService';

export default function TodoList() {

  //STATE
  const [TodoList, setTodoList] = useState();

  //USE.EFFECT
  useEffect(()=>{
    TodoService.saveTodo.
    then((response)=>{
      console.log(response.data);
    })
    .catch((err)=>{console.error(err);})

  });

  //RETURN
  return (

    <div>TodoList</div>

  )


}
