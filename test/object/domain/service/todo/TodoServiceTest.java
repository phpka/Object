/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object.domain.service.todo;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import object.domain.model.Todo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class TodoServiceTest {
    private EJBContainer container;
    private Context context;
    
    public TodoServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        context = container.getContext();
    }
    
    @After
    public void tearDown() {
        container.close();
    }

    /**
     * Test of findAll method, of class TodoService.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        
        TodoService instance = (TodoService)context.lookup("java:global/classes/TodoService");
        List<Todo> result = instance.findAll();
        System.out.println(result);
        assertNotNull(result);
        
    }
    
}
