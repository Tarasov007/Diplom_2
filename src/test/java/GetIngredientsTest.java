import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.Test;
import ru.yandex.practicum.client.ingredient.IngredientClient;

import static org.hamcrest.Matchers.equalTo;

@Slf4j
public class GetIngredientsTest {
    private final IngredientClient ingredientClient = new IngredientClient();

    @Test
    @DisplayName("Получение списка ингредиентов")
    public void getAllIngredients() {
        Response response = ingredientClient.getAllIngredients();
        log.info("Получен ответ от сервера: {}", response.body().asString());

        response.then().statusCode(HttpStatus.SC_OK)
                .and().body("success", equalTo(true));
    }
}
