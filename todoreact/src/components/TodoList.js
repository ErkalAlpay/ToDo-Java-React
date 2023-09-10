import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import TodoService from '../Service/TodoService';


export default function TodoList() {

  //STATE
  const [TodoList, setTodoList] = useState([]);

  //USE EFFECT
  useEffect(() => {
    TodoService.showTodos()
      .then((response) => {
        console.log(response.data);
        setTodoList(response.data);
      })
      .catch((err) => { console.error(err); })

  }, []);

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
    TodoService.showTodos
      .then((response) => {
        console.log(response.data);
        console.log(response.headers);
        setTodoList(response.data);
      })
      .catch((err) => { console.error(err); })
  });

  //SELECT
  const setSelectTodo = (id) => {
    localStorage.setItem("todo_select_id", id);
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
                <Link to={`/todo/update`}>
                  <i onClick={() => setSelectTodo(data.id)} class="fa-solid fa-pen"></i>
                </Link>
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
