import axios from 'axios';
import react, { useEffect, useState, navigate } from 'react'
import TodoService from '../Service/TodoService';

export default function TodoUpdate() {

    //STATE
    const [todoName, setTodoName] = useState([]);
    const [id, setID] = useState(null);

    //USE EFFECT
    useEffect(() => {
        //1.YOL (ID)
        setID(localStorage.getItem("todo_select_id"))

    }); //end EFFECT

    // POST
    const todoUpdate= async (event)=>{
    // Browser'ın post için durmasını istiyorum
    event.preventDefault();


    //NEW TODO OBJECT
    const newTodo={
        id: localStorage.getItem("todo_select_id"),
        todoName
    }

    // API 
    try {
        const response= await TodoService.updateTodo(newTodo)
        if (response.status===200){
          navigate(TodoService.showTodos);
        }
     } catch (err) {
      console.error(err);
     }
    }

    //RETURN
    return (
        <>
      <form>
        <h2 className="display-3 mt-4"></h2>
        <div className="form-group">
          <span>{'newtodo_name'}</span>
          <input 
          type="text" 
          className="form-control" 
          placeholder="newtodo_name"
          required={true}
          autoFocus={true}
          id="newtodo_data"
          name="newtodo_data"
          onChange={(event)=>{setTodoName(event.target.value)}}
          value={todoName}
          />
          </div>
          <button type='submit' className="btn btn-primary mt-3" onClick={todoUpdate}>{('todo/update')}</button>
      </form>
      <br /><br /><br /><br /><br /><br /><br /><br />
    </>
    )
}
