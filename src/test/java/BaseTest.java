import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import ru.yandex.practicum.client.user.UserClient;
import ru.yandex.practicum.generator.UserGenerator;
import ru.yandex.practicum.model.user.User;

@Slf4j
public class BaseTest {
    public static final String ACCESS_TOKEN = "accessToken";
    protected final UserClient userClient = new UserClient();
    protected final UserGenerator userGenerator = new UserGenerator();
    protected User user;
    protected String accessToken;
    protected Response responseCreateUser;


    @Before
    public void createUser() {
        user = userGenerator.createUser();
        responseCreateUser = userClient.registerUser(user);
        accessToken = responseCreateUser.body().path(ACCESS_TOKEN);
    }

    @After
    public void deleteUser() {
        if (user != null) {
            userClient.deleteUser(user, accessToken);
        }
    }
}
