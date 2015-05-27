/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object.domain.service.todo;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import object.domain.common.exception.BusinessException;
import object.domain.common.exception.ResourceNotFoundException;
import object.domain.model.Todo;

/**
 *
 */
@Stateless
public class TodoService {
    private static final long MAX_UNFINISHED_COUNT = 5;
    @PersistenceContext
    protected EntityManager entityManager;
    
    public List<Todo> findAll() {
        TypedQuery<Todo> q = entityManager.createNamedQuery("Todo.findAll", Todo.class);
        return q.getResultList();
    }
    public Todo findOne(Integer id) {
        Todo todo = entityManager.find(Todo.class, id);
        if (todo == null) {
            throw new ResourceNotFoundException("[E404] The request Todo is not found. (id=" + id + ")");
        }
        return todo;
    }
    public Todo create(Todo todo) {
        TypedQuery<Long> q = entityManager.createQuery("SELECT COUNT(x) FROM Todo x WHERE x.finished = :finished", Long.class)
                .setParameter("finished", false);
        long unfinishedCount = q.getSingleResult();
        if (unfinishedCount > MAX_UNFINISHED_COUNT) {
            throw new BusinessException("[E001] The count of unfinished Todo must not be over" + MAX_UNFINISHED_COUNT + ".");
        }
        todo.setFinished(false);
        todo.setCreatedAt(new Date());
        entityManager.persist(todo);
        return todo;
    }
    public Todo finish(Integer id) {
        Todo todo = findOne(id);
        if (todo.getFinished()) {
            throw new BusinessException("[E002] The request Todo is already finish. (id=" + id + ")");
        }
        todo.setFinished(true);
        entityManager.merge(todo);
        return todo;
    }
    public void delete(Integer id) {
        Todo todo = findOne(id);
        entityManager.remove(todo);
    }
}
