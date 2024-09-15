package ru.yandex.practicum.model.Ingredient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString@EqualsAndHashCode
public class IngredientData {
    List<Ingredient> ingredients = new ArrayList<>();

    public IngredientData() {
        setIngredients();
    }

    public void setIngredients() {
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa6d",
                "Флюоресцентная булка R2-D3",
                "bun",
                44,
                26,
                85,
                643,
                988,
                "https://code.s3.yandex.net/react/code/bun-01.png",
                "https://code.s3.yandex.net/react/code/bun-01-mobile.png",
                "https://code.s3.yandex.net/react/code/bun-01-large.png",
                0
        ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa6f",
                "Мясо бессмертных моллюсков Protostomia",
                "main",
                443,
                244,
                33,
                420,
                1337,
                "https://code.s3.yandex.net/react/code/meat-02.png",
                "https://code.s3.yandex.net/react/code/meat-02-mobile.png",
                "https://code.s3.yandex.net/react/code/meat-02-large.png",
                0
        ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa70",
                "Говяжий метеорит (отбивная)",
                "main",
                800,
                800,
                300,
                2674,
                3000,
                "https://code.s3.yandex.net/react/code/meat-04.png",
                "https://code.s3.yandex.net/react/code/meat-04-mobile.png",
                "https://code.s3.yandex.net/react/code/meat-04-large.png",
                0
        ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa71",
                "Биокотлета из марсианской Магнолии",
                "main",
                420,
                142,
                242,
                4242,
                424,
                "https://code.s3.yandex.net/react/code/meat-01.png",
                "https://code.s3.yandex.net/react/code/meat-01-mobile.png",
                "https://code.s3.yandex.net/react/code/meat-01-large.png",
                0
        ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa72",
                "Соус Spicy-X",
                "sauce",
                30,
                20,
                40,
                30,
                90,
                "https://code.s3.yandex.net/react/code/sauce-02.png",
                "https://code.s3.yandex.net/react/code/sauce-02-mobile.png",
                "https://code.s3.yandex.net/react/code/sauce-02-large.png",
                0
        ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa6e",
                "Филе Люминесцентного тетраодонтимформа",
                "main",
                44,
                26,
                85,
                643,
                988,
                "https://code.s3.yandex.net/react/code/meat-03.png",
                "https://code.s3.yandex.net/react/code/meat-03-mobile.png",
                "https://code.s3.yandex.net/react/code/meat-03-large.png",
                0
        ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa73",
                "Соус фирменный Space Sauce",
                "sauce",
                50,
                22,
                11,
                14,
                80,
                "https://code.s3.yandex.net/react/code/sauce-04.png",
                "https://code.s3.yandex.net/react/code/sauce-04-mobile.png",
                "https://code.s3.yandex.net/react/code/sauce-04-large.png",
                0
        ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa74",
                "Соус традиционный галактический",
                "sauce",
                42,
                24,
                42,
                99,
                15,
                "https://code.s3.yandex.net/react/code/sauce-03.png",
                "https://code.s3.yandex.net/react/code/sauce-03-mobile.png",
                "https://code.s3.yandex.net/react/code/sauce-03-large.png",
                0
        ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa6c",
                "Краторная булка N-200i",
                "bun",
                80,
                24,
                53,
                420,
                1255,
                "https://code.s3.yandex.net/react/code/bun-02.png",
                "https://code.s3.yandex.net/react/code/bun-02-mobile.png",
                "https://code.s3.yandex.net/react/code/bun-02-large.png",
                0
        ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa75",
                "Соус с шипами Антарианского плоскоходца",
                "sauce",
                101,
                99,
                100,
                100,
                88,
                "https://code.s3.yandex.net/react/code/sauce-01.png",
                "https://code.s3.yandex.net/react/code/sauce-01-mobile.png",
                "https://code.s3.yandex.net/react/code/sauce-01-large.png",
                0
        ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa76",
                "Хрустящие минеральные кольца",
                "main",
                808,
                689,
                609,
                986,
                300,
                "https://code.s3.yandex.net/react/code/mineral_rings.png",
                "https://code.s3.yandex.net/react/code/mineral_rings-mobile.png",
                "https://code.s3.yandex.net/react/code/mineral_rings-large.png",
                0
    ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa77",
                "Плоды Фалленианского дерева",
                "main",
                20,
                5,
                55,
                77,
                874,
                "https://code.s3.yandex.net/react/code/sp_1.png",
                "https://code.s3.yandex.net/react/code/sp_1-mobile.png",
                "https://code.s3.yandex.net/react/code/sp_1-large.png",
                0
        ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa78",
                "Кристаллы марсианских альфа-сахаридов",
                "main",
                234,
                432,
                111,
                189,
                762,
                "https://code.s3.yandex.net/react/code/core.png",
                "https://code.s3.yandex.net/react/code/core-mobile.png",
                "https://code.s3.yandex.net/react/code/core-large.png",
                0
        ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa79",
                "Мини-салат Экзо-Плантаго",
                "main",
                1,
                2,
                3,
                6,
                4400,
                "https://code.s3.yandex.net/react/code/salad.png",
                "https://code.s3.yandex.net/react/code/salad-mobile.png",
                "https://code.s3.yandex.net/react/code/salad-large.png",
                0
        ));
        ingredients.add(new Ingredient(
                "61c0c5a71d1f82001bdaaa7a",
                "Сыр с астероидной плесенью",
                "main",
                84,
                48,
                420,
                3377,
                4142,
                "https://code.s3.yandex.net/react/code/cheese.png",
                "https://code.s3.yandex.net/react/code/cheese-mobile.png",
                "https://code.s3.yandex.net/react/code/cheese-large.png",
                0
        ));
    }
}
