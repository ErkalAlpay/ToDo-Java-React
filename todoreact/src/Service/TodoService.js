import axios from "axios";

class TodoService {

    //Creating TO-DO
    //http://localhost:8080/create
    saveTodo(todo) {

        return axios.post(`http://localhost:8080/todo/create`, todo,)
    }



    //Deleting TO-DO
    //http://localhost:8080/delete
    deleteTodo(id) {

        return axios.put(`http://localhost:8080/delete/${id}`)
    }

    //Deleting All TO-DO
    //http://localhost:8080/deleteall
    deleteAll() {

        return axios.get(`http://localhost:8080/deleteall`)
    }


    //Checkbox for completed TO-DO
    //http://localhost:8080/check
    checkTodo(id) {

        return axios.put(`http://localhost:8080/check/${id}`)

    }

    //Updating TO-DO
    //http://localhost:8080/update
    updateTodo(newTodo) {


        return axios.post("http://localhost:8080/update", newTodo)


    }

    //Selecting all TO-DO's
    //http://localhost:8080/

    showTodos(tokenjson) {

        return axios.post(`http://localhost:8080/todo/show`, tokenjson)
    }



} //end class






export default new TodoService();