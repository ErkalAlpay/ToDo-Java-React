import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import axios from "axios";


export default function TodoList() {



  //STATE
  const [TodoList, setTodoList] = useState([]);



  //USE EFFECT
  useEffect(() => {
    axios.get("http://localhost:8080/")
      .then((response) => {
        console.log(response.data);
        setTodoList(response.data);
      })
      .catch((err) => { console.error(err); })

  }, []);


  // //UPDATE

  // const setUpdateList = (data) => {
  //   let { id, todoName } = data;
  //   localStorage.setItem("todo_update_id", id);
  //   localStorage.setItem("todo_update_todoName", todoName);
  // }

  //CHECKING-UNCHECKING TO-DO
  const isCompleted = (id) => {
    axios.put(`http://localhost:8080/check/${id}`)
      .then((response) => {
        //"..." işareti TodoList içindeki verileri dışarı aktarıyor (dizi içine)
        TodoList.push(response.data);
        setTodoList(TodoList);
        //location.reload();

      });

  }

  //DELETE
  const setDeleteTodo = ((id) => {

    if (window.confirm("Silmek istediğine emin misin")) {
      axios.put(`http://localhost:8080/delete/${id}`)
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
    axios.get("http://localhost:8080/")
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

  //()=> (todocheck.checked= data.isCompleted)


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
                   <i class="fa-solid fa-trash text-danger" onClick={()=> setDeleteTodo(data.id)}></i>               
                </td>

                <td>
                  

                </td>

              </tr>
            )
          }
        </tbody>
      </table>

    </>

  )


}
