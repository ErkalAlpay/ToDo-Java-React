import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import TodoService from '../Service/TodoService';


export default function TodoList() {

  //STATE
  const [TodoList, setTodoList] = useState([]);
  const [todo, setTodo] = useState([]);
  //const [id, setID] = useState(null);
    

  //USE EFFECT
  useEffect(() => {
    
    TodoService.showTodos()
      .then((response) => {
        console.log(response.data);
        setTodoList(response.data);
      })
      .catch((err) => { console.error(err); })

  }, []);


  // POST
  const todoUpdate= async (event)=>{
    // Browser'ın post için durmasını istiyorum
    event.preventDefault();
    const id = localStorage.getItem("todo_select_id")
    //NEW TODO OBJECT
    const newTodo={
        id: id,
        todo,
    }
    console.log(newTodo);
    // API 
    try {
        const response= await TodoService.updateTodo(newTodo)
        if (response.status===200){
          //Changing the page to ()
          window.location.assign("http://localhost:3000/");
        }
     } catch (err) {
      console.error(err);
     }
    }//END POST

  //CHECKING-UNCHECKING TO-DO
  const isCompleted = (id) => {
    TodoService.checkTodo(id)
      .then((response) => {
        //"..." işareti TodoList içindeki verileri dışarı aktarıyor (dizi içine)
        TodoList.push(response.data);
        setTodoList(TodoList);
        getList();
        //location.reload();
      });
  }

  //DELETE
  const setDeleteTodo = ((id) => {
    if (window.confirm("Silmek istediğine emin misin")) {
      TodoService.deleteTodo(id)
        .then(() => {
          getList();
        })
        .catch((err) => { console.error(err); })
    }
    else {
      alert("Silinmedi")
    }
  });

  //VIEW
  const getList = (() => {
    TodoService.showTodos()
      .then((response) => {
        console.log(response.data);
        console.log(response.headers);
        setTodoList(response.data);
      })
      .catch((err) => { console.error(err); })
  });

  //SELECT
  const setSelectTodo = (id) => {
    localStorage.setItem("todo_select_id",id);
  }

  //RETURN
  return (
    <>
      <h1 className="text-center display-4"><b>To-Do's</b></h1>
      <table class="table">
        <thead>
          <tr>
            <th>To-Do's</th>
            <th>Description</th>
            <th>Check</th>
            <th>Update</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {
            TodoList.map((data) =>
              <tr key={data.id}>
                <td>{data.id}</td>
                <td>{data.todo}</td>
                <td>
                  <input type='checkbox' id="abc" checked={data.isCompleted} onChange={() => isCompleted(data.id)} />
                  <label for="abc">
                    {(data.isCompleted) ? "Tamamlandı" : "Tamamlanmadı"}
                  </label>
                </td>
                <td>
                  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" onClick={setSelectTodo(data.id)}>
                    <i class="fa-solid fa-pen"></i>
                  </button>
                  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h1 class="modal-title fs-5" id="exampleModalLabel"><b>To-Do Giriniz</b></h1>
                        </div>
                        <div class="modal-body">
                          <input
                            type="text"
                            className="form-control"
                            placeholder="Todo giriniz"
                            required={true}
                            autoFocus={true}
                            id="newtodo_data"
                            name="newtodo_data"
                            onChange={(event) => { setTodo(event.target.value); }}
                            value={todo}
                          />
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                          <button type="button" class="btn btn-primary" onClick={todoUpdate}> {('Confirm')}</button>
                        </div>
                      </div>
                    </div>
                  </div>
                </td>
                <td>
                  <i class="fa-solid fa-trash text-danger" onClick={() => setDeleteTodo(data.id)}></i>
                </td>
              </tr>
            )
          }
        </tbody>
      </table>
    </>
  )
}
