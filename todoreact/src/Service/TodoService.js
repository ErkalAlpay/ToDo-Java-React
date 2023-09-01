import axios from "axios";

class TodoService {




    //Creating TO-DO
    //http://localhost:8080/create
    saveTodo(todo) {

        return axios.post(`/create/${todo}`)
    }



    //Deleting TO-DO
    //http://localhost:8080/delete
    deleteTodo(id) {

        return axios.post(`/delete${id}`)
    }

    //Deleting All TO-DO
    //http://localhost:8080/deleteall
    deleteAll() {

        return axios.get(`/deleteall`)
    }



    //Updating TO-DO
    //http://localhost:8080/update
    updateTodo(newTodo, id) {


        return axios.post(`/update/${newTodo,id}`) 


    }

    //Selecting all TO-DO's
    //http://localhost:8080/

    showTodos() {

        return axios.delete();
    }



} //end class

export default new TodoService();