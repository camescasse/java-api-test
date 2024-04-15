import org.example.models.Address;
import org.example.models.Company;
import org.example.models.Geo;
import org.example.models.User;
import org.example.services.UserService;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class UsersTest {

    @Test
    public void post_Users_ReturnsCreated() {
        var service = new UserService();

        var geo = new Geo("-4.5956887", "-138.76742");
        var address = new Address("Tina Prairie", "95772", "Alphonse", "84683", geo);
        var company = new Company("Sanford", "Programmable group", "streamline action-items");
        var user = new User(
                11,
                "Bill Cartwright",
                "cart11",
                "cart11@gmail.com",
                address,
                "1-477-445-5187",
                "cart11.com",
                company);

        var newUser = service.create(user);

        assertThat(user.id()).isEqualTo(newUser.id());
    }

    @Test
    public void getAll_Users_ReturnsOk() {
        var users = new UserService();
        assertThat(users.getAll()).isNotEmpty();
    }

    @Test
    public void getById_Users_ReturnsUser() {
        var service = new UserService();
        assertThat(service.getById(1)).isNotNull();
    }

    @Test
    public void putById_Users_ReturnsUpdated() {
        var service = new UserService();

        var geo = new Geo("-24.5956887", "-42.61542");
        var address = new Address("Mark Twain", "66428", "Margarita", "49875", geo);
        var company = new Company("North Galaxy", "One individual", "simple motives");
        var newUser = new User(
                6,
                "John Vanderbilt",
                "johnv18",
                "johnv18@gmail.com",
                address,
                "1-887-355-1867",
                "johnv18.com",
                company);

        var updatedUser = service.override(newUser, newUser.id());

        assertThat(newUser.username()).isEqualTo(updatedUser.username());
    }

    @Test
    public void patchById_Users_ReturnsUpdated() {
        var service = new UserService();

        var newUser = new User(
                7,
                null,
                "johnny13",
                null,
                null,
                null,
                null,
                null);

        var updatedUser = service.update(newUser, newUser.id());

        assertThat(newUser.username()).isEqualTo(updatedUser.username());
    }

    @Test
    public void deleteById_Users_ReturnsOk() {
        var service = new UserService();
        assertThat(service.delete(1)).isEqualTo(200);
    }

}