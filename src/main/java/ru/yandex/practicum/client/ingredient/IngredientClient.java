package ru.yandex.practicum.client.ingredient;

import io.restassured.response.Response;
import ru.yandex.practicum.client.Client;

public class IngredientClient extends Client {
    private static final String ROOT = "/ingredients";

    public Response getAllIngredients() {
        return specification()
                .get(ROOT);
    }
}
