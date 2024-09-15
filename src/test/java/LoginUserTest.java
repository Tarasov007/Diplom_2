import org.apache.http.HttpStatus;
import org.junit.Test;
import ru.yandex.practicum.client.user.UserClient;
import ru.yandex.practicum.model.user.UserWithoutEmail;
import ru.yandex.practicum.model.user.UserWithoutName;
import ru.yandex.practicum.model.user.UserWithoutPassword;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginUserTest extends BaseTest {
    public static final String SUCCESS = "success";
    public static final String INCORRECT_EMAIL = "incorrectEmail@new.ru";
    public static final String INCORRECT_PASSWORD = "incorrect_password";
    private final UserClient userClient = new UserClient();

    @Test
    public void loginCorrectUser() {
        userClient.loginUser(user)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and().body(SUCCESS, equalTo(true));
    }

    @Test
    public void loginWithNameNull() {
        user.setName(null);

        userClient.loginUser(user)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and().body(SUCCESS, equalTo(true));
    }

    @Test
    public void loginWithoutName() {
        UserWithoutName userWithoutName = new UserWithoutName(user.getEmail(), user.getPassword());

        userClient.loginUserWithoutName(userWithoutName)
                .statusCode(HttpStatus.SC_OK)
                .and().body(SUCCESS, equalTo(true));
    }

    @Test
    public void loginWithPasswordNull() {
        user.setPassword(null);

        userClient.loginUser(user)
                .then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .and().body(SUCCESS, equalTo(false));
    }

    @Test
    public void loginWithPasswordIncorrect() {
        user.setPassword(INCORRECT_PASSWORD);

        userClient.loginUser(user)
                .then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .and().body(SUCCESS, equalTo(false));
    }

    @Test
    public void loginWithoutPassword() {
        UserWithoutPassword userWithoutPassword = new UserWithoutPassword(user.getEmail(), user.getName());

        userClient.loginUserWithoutPassword(userWithoutPassword)
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .and().body(SUCCESS, equalTo(false));
    }

    @Test
    public void loginWithEmailNull() {
        user.setEmail(null);

        userClient.loginUser(user)
                .then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .and().body(SUCCESS, equalTo(false));
    }

    @Test
    public void loginWithEmailIncorrect() {
        user.setEmail(INCORRECT_EMAIL);

        userClient.loginUser(user)
                .then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .and().body(SUCCESS, equalTo(false));
    }

    @Test
    public void loginWithoutEmail() {
        UserWithoutEmail userWithoutEmail = new UserWithoutEmail(user.getPassword(), user.getName());

        userClient.loginUserWithoutEmail(userWithoutEmail)
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .and().body(SUCCESS, equalTo(false));
    }
}
