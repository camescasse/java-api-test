import org.example.models.Todo;
import org.example.services.TodoService;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class TodosTest {

    @Test
    public void post_Todos_ReturnsCreated() {
        var service = new TodoService();
        var todo = new Todo(3001, 201, "titulote", false);

        var newTodo = service.create(todo);

        assertThat(newTodo.userId()).isEqualTo(todo.userId());
    }

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
    public void putById_Todos_ReturnsUpdated() {
        var service = new TodoService();
        var newTodo = new Todo(3001, 151, "titulo fixed", false);

        var updatedTodo = service.override(newTodo, newTodo.id());

        assertThat(newTodo.title()).isEqualTo(updatedTodo.title());
    }

    @Test
    public void patchById_Todos_ReturnsUpdated() {
        var service = new TodoService();
        var newTodo = new Todo(null, 181, "title fixed", null);

        var updatedTodo = service.update(newTodo, newTodo.id());

        assertThat(newTodo.title()).isEqualTo(updatedTodo.title());
    }

    @Test
    public void deleteById_Todos_ReturnsOk() {
        var service = new TodoService();
        assertThat(service.delete(1)).isEqualTo(200);
    }

}
