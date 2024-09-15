package ru.yandex.practicum.model.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class UserWithoutEmail {
    private String password;
    private String name;
}
