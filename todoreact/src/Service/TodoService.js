const axios = require("axios");

class TodoController {



    //Creating TO-DO
    //http://localhost:8080/create
    saveTodo(todo) {

        return axios.post('/create')
    }



    //Deleting TO-DO
    //http://localhost:8080/delete
    deleteTodo(id) {
        todoService.deleteTodo(id);

        return axios.post('/delete')
    }

    //Deleting All TO-DO
    //http://localhost:8080/deleteall
    @GetMapping("deleteall")
    deleteAll() {


        return axios.get('/deleteall')
    }



    //Updating TO-DO
    //http://localhost:8080/update
    updateTodo(newTodo, id) {


        return axios.post('/update')


    }

    //Selecting all TO-DO's
    //http://localhost:8080/

    showTodos() {

        return axios.get('/')
    }



}