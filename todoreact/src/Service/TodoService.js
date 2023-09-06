import axios from "axios";

class TodoService {

    //Creating TO-DO
    //http://localhost:8080/create
    saveTodo(todo) {

        return axios.post(`http://localhost:8080/create`,todo,)
    }



    //Deleting TO-DO
    //http://localhost:8080/delete
    deleteTodo(id) {

        return axios.post(`http://localhost:8080/delete`,id,)
    }

    //Deleting All TO-DO
    //http://localhost:8080/deleteall
    deleteAll() {

        return axios.get(`http://localhost:8080/deleteall`)
    }



    //Updating TO-DO
    //http://localhost:8080/update
    updateTodo(newTodo, id) {


        return axios.post(`http://localhost:8080/update/${newTodo,id}`) 


    }

    //Selecting all TO-DO's
    //http://localhost:8080/

    showTodos() {

        return axios.get(`http://localhost:8080/`)
    }



} //end class






export default new TodoService();