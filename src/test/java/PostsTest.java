import org.example.models.Post;
import org.example.services.PostService;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class PostsTest {

    @Test
    public void post_Posts_returnsCreated() {
        var service = new PostService();
        var post = new Post(25, 101, "mi primer post", "final");

        var newPost = service.create(post);

        assertThat(newPost.userId()).isEqualTo(post.userId());
    }

    @Test
    public void getAll_Posts_ReturnsOk() {
        var service = new PostService();
        assertThat(service.getAll()).isNotEmpty();
    }

    @Test
    public void getById_Posts_ReturnsPost() {
        var service = new PostService();
        assertThat(service.getById(1)).isNotNull();
    }

    @Test
    public void putById_Posts_ReturnsUpdated() {
        var service = new PostService();
        var newPost = new Post(1, 3, "mi post reviewed", "final");

        var updatedPost = service.override(newPost, newPost.id());

        assertThat(newPost.title()).isEqualTo(updatedPost.title());
    }

    @Test
    public void patchById_Posts_ReturnsUpdated() {
        var service = new PostService();
        var newPost = new Post(null, 15, "mi post fixed", null);

        var updatedPost = service.update(newPost, newPost.id());

        assertThat(newPost.title()).isEqualTo(updatedPost.title());
    }

    @Test
    public void deleteById_Posts_ReturnsOk() {
        var service = new PostService();
        assertThat(service.delete(1)).isEqualTo(200);
    }

}
