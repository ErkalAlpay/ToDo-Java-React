import React, { useState, useEffect } from 'react';
import TodoService from '../Service/TodoService';


function TodoCreate({ }) {


  //STATE
  const [todoName, setTodoName] = useState("");
  const [error, setError] = useState();

  useEffect(() => {
    setError(undefined);
  }, [todoName]);

  const addTodo = async (event) => {
    event.preventDefault();

    // Yeni todo nesnesini burada oluşturmalısınız
    const newTodo = {
      "todo": todoName
    };
    console.log(newTodo);

    //SERVICE
    try {
      const response = await TodoService.saveTodo(newTodo);
      // Burada response ile ne yapmak istediğinizi ekleyebilirsiniz
      window.location.assign("http://localhost:3000/");
    } catch (err) {
      setError(err.response.data.validationErrors);
    }

  }

  // CHANGE
  const todoOnChange = (event) => {
    const { todoName, value } = event.target;
    // onChange
    setTodoName(value)
  }


  // RETURN
  return (
    <React.Fragment>
      <form>
        <h2 className="text-center display-3 mt-4">{('todo')}</h2>
        <div className="form-group">
          <span>{('')}</span>
          <input
            type="text"
            className="form-control"
            placeholder={('todo input')}
            required={true}
            autoFocus={true}
            id="todo_data"
            name="todo_data"
            onChange={todoOnChange}
          />
          {error ? <div className="alert alert-danger" role="alert">
            {error.todo}
          </div> : ""}
        </div>
        <button
          type='submit'
          className="btn btn-primary mt-3"
          disabled={!true}
          onClick={addTodo}>{('add')}</button>
      </form>
      <br /><br />
    </React.Fragment>
  ) //end return
} //end fucntion



export default TodoCreate;
