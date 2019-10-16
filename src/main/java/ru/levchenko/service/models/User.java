package ru.levchenko.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login", nullable = false)
    @Pattern(regexp = "[a-zA-Z0-9]{4,16}", message = "от 4 до 16 символов(латиница/цифры)")
    private String login;
    @Transient
    @Column(name = "password", nullable = false)
    @Pattern(regexp = "[a-zA-Z0-9.]{8,16}", message ="от 8 до 16 символов(латиница/цифры/знаки)")
    private String password;

    private String hashPassword;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "uploadphoto")
    private String uploadPhoto;//путь к аватару юзера(скинуть в отдельную СУБД все файлы)
    @Column(nullable = false)
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
            message ="укажите действующий емейл")
    private String email;
    @Column
    private String activationCode;
    @Column
    private boolean activated;


    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "owner")
    private List<Product> productList;

    public boolean isAdmin(){
        if (getRole().name().equals(Role.ADMIN.name())){
            return true;
        }
        return false;
    }


}
