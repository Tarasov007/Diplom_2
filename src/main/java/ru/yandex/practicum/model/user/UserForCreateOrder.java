package ru.yandex.practicum.model.user;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserForCreateOrder {
    private String name;
    private String email;
    private String createAt;
    private String updateAt;
}
