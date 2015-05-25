/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object.app.todo;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import object.domain.model.Todo;
import object.domain.service.todo.TodoService;

/**
 *
 * @author 9918
 */
//@ManagedBean
@Named(value="todoController")
@RequestScoped
public class TodoController {
    @EJB
    protected TodoService todoService;
    protected List<Todo> todoList;
    /**
     * Creates a new instance of TodoController
     */
    public TodoController() {
    }
    public List<Todo> getTodoList() {
        return todoList;
    }
    @PostConstruct
    public void init() {
        todoList = todoService.findAll();
    }
}
