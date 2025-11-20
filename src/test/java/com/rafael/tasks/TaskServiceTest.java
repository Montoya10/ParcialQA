package com.rafael.tasks;
import com.rafael.tasks.model.*;
import com.rafael.tasks.service.TaskService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TaskServiceTest {
    @Test void crearTareaCorrectamente(){
        TaskService service=new TaskService();
        Task t=service.createTask("Estudiar CI/CD","Repasar pipelines",Priority.HIGH);
        assertEquals("Estudiar CI/CD",t.getTitle());
        assertEquals(Status.PENDING,t.getStatus());
    }
    @Test void noPermitirTituloVacio(){
        TaskService service=new TaskService();
        assertThrows(IllegalArgumentException.class,()->service.createTask("","desc",Priority.LOW));
    }
    @Test void cambiarEstadoCorrectamente(){
        TaskService service=new TaskService();
        Task t=service.createTask("Hacer pruebas","JUnit",Priority.MEDIUM);
        t.setStatus(Status.IN_PROGRESS);
        assertEquals(Status.IN_PROGRESS,t.getStatus());
        t.setStatus(Status.DONE);
        assertEquals(Status.DONE,t.getStatus());
    }
    @Test void noPermitirFinalizarSinEstarEnProgreso(){
        TaskService service=new TaskService();
        Task t=service.createTask("Errores","Validar flujo",Priority.LOW);
        assertThrows(IllegalStateException.class,()->t.setStatus(Status.DONE));
    }
}