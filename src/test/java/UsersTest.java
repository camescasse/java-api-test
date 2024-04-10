import com.github.javafaker.Faker;
import org.example.models.Address;
import org.example.models.Company;
import org.example.models.Geo;
import org.example.models.User;
import org.example.services.UserService;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class UsersTest {

    @Test
    public void getAll_Users_ReturnsOk() {
        var users = new UserService();
        assertThat(users.getAll()).isNotEmpty();
    }

    @Test
    public void post_Users_ReturnsCreated() {
        var service = new UserService();
        var faker = new Faker();

        var geo = new Geo(
                faker.address().latitude(),
                faker.address().longitude());
        var address = new Address(
                faker.address().streetName(),
                faker.address().buildingNumber(),
                faker.address().city(),
                faker.address().zipCode(),
                geo);
        var company = new Company(
                faker.company().name(),
                faker.company().catchPhrase(),
                faker.company().bs());
        var user = new User(
                11,
                faker.name().fullName(),
                faker.funnyName().name(),
                faker.pokemon().name() + "@gmail.com",
                address,
                faker.phoneNumber().cellPhone(),
                faker.dragonBall().character() + ".com",
                company);

        var newUser = service.create(user);

        assertThat(user.id()).isEqualTo(newUser.id());
    }
}
