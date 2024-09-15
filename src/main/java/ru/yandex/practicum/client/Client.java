package ru.yandex.practicum.client;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Client {
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    public static final String BASE_PATH = "/api";

    public RequestSpecification specification() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(BASE_PATH);
    }
}
