package com.picpaysimplificado.domain.user;

import com.picpaysimplificado.domain.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING) //essa anotação diz que enumType vai representar um dos valores do enum
    private UserType userType;

    public User(UserDTO user) {
        this.firstName = user.firstName();
        this.lastName = user.lastName();
        this.document = user.document();
        this.email = user.email();
        this.password = user.password();
        this.balance = user.balance();
        this.userType = user.userType();
    }
}
