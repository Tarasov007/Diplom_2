import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.Test;
import ru.yandex.practicum.client.order.OrderClient;
import ru.yandex.practicum.generator.IngredientsGenerator;
import ru.yandex.practicum.model.Ingredient.Ingredient;
import ru.yandex.practicum.model.order.OrderAfterCreate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

@Slf4j
public class CreateOrderWithLoginTest extends BaseTest {
    public static final String SUCCESS = "success";
    public static final String ORDER = "order";
    public static final String MESSAGE = "message";
    public static final String TEXT_MESSAGE_INGREDIENT_IDS_MUST_BE_PROVIDED = "Ingredient ids must be provided";
    public static final String INGREDIENTS = "ingredients";
    private final OrderClient orderClient = new OrderClient();
    private final IngredientsGenerator ingredientsGenerator = new IngredientsGenerator();
    private OrderAfterCreate orderAfterCreate;

    @Test
    @DisplayName("Создание заказа с авторизацией")
    public void createCorrectOrderWithLogin() {
        Map<String, String[]> ingredientsMap = ingredientsGenerator.getCorrectIngredients();
        Response response = orderClient.createOrderWithLogin(ingredientsMap, accessToken);

        orderAfterCreate = response.body().jsonPath().getObject(ORDER, OrderAfterCreate.class);

        List<String> expected = new ArrayList<>(Arrays.asList(ingredientsMap.get(INGREDIENTS)));
        List<String> actual = getActual(orderAfterCreate);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Создание заказа с авторизацией, без ингредиентов")
    public void createOrderWithoutIngredients() {
        Map<String, String[]> ingredientsMap = ingredientsGenerator.getEmptyIngredients();
        log.info("Список ингредиентов: {}", ingredientsMap);

        Response response = orderClient.createOrderWithLogin(ingredientsMap, accessToken);
        log.info("Получен ответ от сервера: {}", response.body().asString());

        response.then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .and().body(SUCCESS, equalTo(false))
                .and().body(MESSAGE, equalTo(TEXT_MESSAGE_INGREDIENT_IDS_MUST_BE_PROVIDED));
    }


    @Test
    @DisplayName("Создание заказа с авторизацией, с некорректным хэшем ингредиентов")
    public void createOrderWithIncorrectIngredients() {
        Map<String, String[]> ingredientsMap = ingredientsGenerator.getIncorrectIngredients();
        log.info("Список ингредиентов: {}", ingredientsMap);

        Response response = orderClient.createOrderWithLogin(ingredientsMap, accessToken);
        log.info("Получен ответ от сервера: {}", response.body().asString());

        response.then()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    private List<String> getActual(OrderAfterCreate orderAfterCreate) {
        List<String> actual = new ArrayList<>();
        for (Ingredient ingredient : orderAfterCreate.getIngredients()) {
            actual.add(ingredient.get_id());
        }
        return actual;
    }
}
