import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.Test;
import ru.yandex.practicum.client.user.UserClient;
import ru.yandex.practicum.generator.UserGenerator;
import ru.yandex.practicum.model.user.User;
import ru.yandex.practicum.model.user.UserWithoutEmail;
import ru.yandex.practicum.model.user.UserWithoutName;
import ru.yandex.practicum.model.user.UserWithoutPassword;

import static org.hamcrest.CoreMatchers.equalTo;

@Slf4j
public class CreateInvalidUserTest {
    public static final String SUCCESS = "success";
    public static final String MESSAGE = "message";
    public static final String TEXT_MESSAGE_REQUIRED_FIELDS = "Email, password and name are required fields";
    private final UserClient userClient = new UserClient();
    private final UserGenerator userGenerator = new UserGenerator();

    @Test
    public void registerUserWithoutName() {
        UserWithoutName userWithoutName = userGenerator.createUserWithoutName();

        ValidatableResponse response = userClient.registerUserWithoutName(userWithoutName);

        response.statusCode(HttpStatus.SC_FORBIDDEN)
                .and().body(SUCCESS, equalTo(false))
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_REQUIRED_FIELDS));
    }

    @Test
    public void registerUserWithNameNull() {
        User user = userGenerator.createUserWithNameNull();

        Response response = userClient.registerUser(user);

        response.then()
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .and().body(SUCCESS, equalTo(false))
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_REQUIRED_FIELDS));
    }

    @Test
    public void registerUserWithoutPassword() {
        UserWithoutPassword userWithoutPassword = userGenerator.createUserWithoutPassword();

        ValidatableResponse response = userClient.registerUserWithoutPassword(userWithoutPassword);

        response.statusCode(HttpStatus.SC_FORBIDDEN)
                .and().body(SUCCESS, equalTo(false))
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_REQUIRED_FIELDS));
    }

    @Test
    public void registerUserWithPasswordNull() {
        User user = userGenerator.createUserWithPasswordNull();

        Response response = userClient.registerUser(user);

        response.then()
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .and().body(SUCCESS, equalTo(false))
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_REQUIRED_FIELDS));
    }

    @Test
    public void registerUserWithoutEmail() {
        UserWithoutEmail userWithoutEmail = userGenerator.createUserWithoutEmail();

        ValidatableResponse response = userClient.registerUserWithoutEmail(userWithoutEmail);

        response.statusCode(HttpStatus.SC_FORBIDDEN)
                .and().body(SUCCESS, equalTo(false))
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_REQUIRED_FIELDS));
    }

    @Test
    public void registerUserWithEmailNull() {
        User user = userGenerator.createUserWithEmailNull();

        Response response = userClient.registerUser(user);

        response.then()
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .and().body(SUCCESS, equalTo(false))
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_REQUIRED_FIELDS));
    }
}
