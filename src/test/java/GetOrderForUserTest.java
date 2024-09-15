import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import ru.yandex.practicum.client.order.OrderClient;
import ru.yandex.practicum.generator.IngredientsGenerator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetOrderForUserTest extends BaseTest {
    private final IngredientsGenerator ingredientsGenerator = new IngredientsGenerator();
    private final OrderClient orderClient = new OrderClient();

    @Test
    public void getOrdersWithAuth() {
        orderClient.createOrderWithLogin(ingredientsGenerator.getCorrectIngredients(), accessToken);
        Response response = orderClient.getOrdersWithAuth(accessToken);

        response.then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("success", equalTo(true))
                .and().body("orders", notNullValue());
    }

    @Test
    public void getOrdersWithoutAuth() {
        Response response = orderClient.getOrdersWithoutAuth();

        response.then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .and().body("success", equalTo(false))
                .and().body("message", equalTo("You should be authorised"));
    }
}
