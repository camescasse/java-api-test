import org.example.models.Todo;
import org.example.services.TodoService;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class TodosTest {
    @Test
    public void getAll_Todos_ReturnsOk() {
        var service = new TodoService();
        assertThat(service.getAll()).isNotEmpty();
    }

    @Test
    public void getById_Todos_ReturnsTodo() {
        var service = new TodoService();
        assertThat(service.getById(1)).isNotNull();
    }

    @Test
    public void post_Todos_ReturnsCreated() {
        var service = new TodoService();
        var todo = new Todo(3001, 201, "titulote", false);

        var newTodo = service.create(todo);

        assertThat(newTodo.userId()).isEqualTo(todo.userId());
    }

    @Test
    public void deleteById_Todos_ReturnsOk() {
        var service = new TodoService();
        assertThat(service.delete(1)).isEqualTo(200);
    }

}
