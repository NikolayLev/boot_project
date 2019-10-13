package ru.levchenko.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.levchenko.service.models.Role;
import ru.levchenko.service.models.State;
import ru.levchenko.service.models.User;
import ru.levchenko.service.repositories.UsersRepository;
import ru.levchenko.service.security.forms.UserForm;
import ru.levchenko.service.services.email.EmailSender;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    EmailSender emailSender;

    public boolean signUp(UserForm userForm) {
        if (findByUserName(userForm.getLogin()).isPresent()) {
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

        emailSender.send(user.getEmail(),"Registration", message);

        return true;

    }

    @Override
    public boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        return email.matches(pattern.pattern());
    }

    @Override
    public boolean checkLogin(String login) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]{4,16}");
        return login.matches(pattern.pattern());
    }

    @Override
    public boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile("[._a-zA-Z0-9!#$@%&,:;'\"'*+-/=?^_`{|}~\\.]{8,16}");
        return password.matches(pattern.pattern());
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
