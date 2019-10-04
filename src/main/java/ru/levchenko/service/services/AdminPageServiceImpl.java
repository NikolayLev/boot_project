package ru.levchenko.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levchenko.service.models.Role;
import ru.levchenko.service.models.State;
import ru.levchenko.service.models.User;
import ru.levchenko.service.repositories.UsersRepository;

import java.util.Map;
import java.util.Optional;

@Service
public class AdminPageServiceImpl implements AdminPageService {

    @Autowired
    UsersRepository usersRepository;

    public void editUser(Map<String,String> form, Long id){

        Role role;
        State state;

        if (form.containsKey("status")){
            state = State.ACTIVE;
        }else{
            state = State.BANNED;
        }

        if(form.containsKey("role")) {
            role = Role.ADMIN;
        } else {
            role = Role.USER;
        }

        User user =
                User.builder()
                .id(id)
                .login(form.get("login"))
                .firstName(form.get("firstName"))
                .lastName(form.get("lastName"))
                .role(role)
                .state(state)
                .build();

        usersRepository.save(user);
    }
}
