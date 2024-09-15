import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.Test;
import ru.yandex.practicum.client.user.UserClient;
import ru.yandex.practicum.generator.UserGenerator;

import static org.hamcrest.CoreMatchers.equalTo;

@Slf4j
public class CreateValidUserTest extends BaseTest {
    public static final String SUCCESS = "success";
    public static final String MESSAGE = "message";
    public static final String TEXT_MESSAGE_EXISTS = "User already exists";
    private final UserClient userClient = new UserClient();
    private final UserGenerator userGenerator = new UserGenerator();

    @Test
    @DisplayName("Регистрация валидного пользователя")
    public void registerUniqueUser() {
        user = userGenerator.createUser();
        log.info("Попытка создания пользователя: {}", user);

        Response response = userClient.registerUser(user);
        log.info("Получен ответ от сервера: {}", response.body().asString());
        accessToken = response.body().path("accessToken");

        response.then()
                .statusCode(HttpStatus.SC_OK)
                .and().body(SUCCESS, equalTo(true));
    }

    @Test
    @DisplayName("Повторная регистрация уже имеющегося пользователя")
    public void registerUserWithExistingEmail() {
        user = userGenerator.createUser();
        Response response = userClient.registerUser(user);
        accessToken = response.body().path("accessToken");
        response.then()
                .statusCode(HttpStatus.SC_OK)
                .and().body(SUCCESS, equalTo(true));

        Response badResponse = userClient.registerUser(user);
        log.info("Попытка создания существующего пользователя: {}", user);
        log.info("Получен ответ от сервера: {}", badResponse.body().asString());

        badResponse.then()
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .and().body(SUCCESS, equalTo(false))
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_EXISTS));
    }
}
