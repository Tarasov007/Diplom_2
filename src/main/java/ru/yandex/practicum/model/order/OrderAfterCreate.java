package ru.yandex.practicum.model.order;

import lombok.*;
import ru.yandex.practicum.model.Ingredient.Ingredient;
import ru.yandex.practicum.model.user.UserForCreateOrder;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderAfterCreate {
    private Ingredient[] ingredients;
    private String _id;
    private UserForCreateOrder owner;
    private String status;
    private String name;
    private String createAt;
    private String updateAt;
    private int number;
    private int price;
}
