import React, { useState, useEffect } from 'react';
import TodoService from '../Service/TodoService';

function TodoCreate({ t }) {

    //REDIRECT
    const navigate = useNavigate();


    //STATE
    const [todo, setTodo] = useState("");
    const [error, setError] = useState();

    useEffect(() => {
        setError(undefined);
    }, [todo]);

    const addTodo = async (event) => {
        event.preventDefault();

        // Yeni todo nesnesini burada oluşturmalısınız
        const newTodo = {
            todo
        };
        console.log(newTodo);

        //SERVICE
        try {
            const response = await TodoService.saveTodo(newTodo);
            // Burada response ile ne yapmak istediğinizi ekleyebilirsiniz
        } catch (err) {
            setError(err.response.data.validationErrors);
        }
    }


     // CHANGE
  const todoOnChange = (event) => {
    const { todo } = event.target;
    //console.log(`${name} => ${value}`);

    // onChange
    setTodo(todo)
  }


    // RETURN
  return (
    <React.Fragment>
      <form>
        <h2 className="display-3 mt-4">{('todo')}</h2>
        <div className="form-group">
          <span>{('todo')}</span>
          <input
            type="text"
            className="form-control"
            placeholder={('todo')}
            required={true}
            autoFocus={true}
            id="todo_data"
            name="todo_data"
            onChange={todoOnChange}
          //onChange={(event)=>{setCategoryName(event.target.value)}}
          />
          {/* state hatayı bootstrap ile alert ekrana basma */}
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
      <br /><br /><br /><br /><br /><br /><br /><br />
    </React.Fragment>
  ) //end return
} //end fucntion



export default TodoCreate;
