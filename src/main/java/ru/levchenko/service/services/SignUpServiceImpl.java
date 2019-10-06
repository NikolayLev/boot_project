package ru.levchenko.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.levchenko.service.models.Role;
import ru.levchenko.service.models.State;
import ru.levchenko.service.models.User;
import ru.levchenko.service.repositories.UsersRepository;
import ru.levchenko.service.security.forms.UserForm;

import java.util.Optional;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean signUp(UserForm userForm){
        if(findByUserName(userForm.getLogin()).isPresent()){
            return false;
        }

        User user = User.builder()
                .login(userForm.getLogin())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .state(State.ACTIVE)
                .role(Role.USER)
                .uploadPhoto("bd027e654c2fbb9f100e372dc2156d4d.jpg")
                .build();
        usersRepository.save(user);
        return true;

    }

    @Override
    public Optional<User> findByUserName(String userName) {
         return usersRepository.findOneByLogin(userName);
    }
}
