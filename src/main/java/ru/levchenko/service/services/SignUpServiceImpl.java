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
import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean signUp(UserForm userForm) {
        if (findByUserName(userForm.getLogin()).isPresent()) {
            return false;
        }

        User user = User.builder()
                .login(userForm.getLogin())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .state(State.BANNED)
                .role(Role.USER)
                .uploadPhoto("bd027e654c2fbb9f100e372dc2156d4d.jpg")
                .activationCode(UUID.randomUUID().toString())
                .email(userForm.getEmail())
                .build();
        usersRepository.save(user);

        String message = String.format(
                "Hello, %s! \n" +
                        "Welcome on our test MarketPlace. Please visit next link for finish registration \n" +
                        "http://localhost/activate/%s",
                user.getLogin(),
                user.getActivationCode()
        );

        return true;

    }

    @Override
    public boolean checkEmail(String email) {
        return false;
    }

    @Override
    public boolean checkLogin(String login) {
        return false;
    }

    @Override
    public boolean checkPassword(String password) {
        return false;
    }

    @Override
    public boolean activateUser(String code) {

        Optional<User> candidate = usersRepository.findOneByActivationCode(code);

        if (!candidate.isPresent()) {
            return false;
        }

        User user = candidate.get();

        user.setActivationCode(null);
        user.setActivated(true);
        usersRepository.save(user);

        return true;

    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return usersRepository.findOneByLogin(userName);
    }
}
