package ru.levchenko.service.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.levchenko.service.repositories.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //возвращает UserDetails по имени юзера. Если такого юзера нет, то выкидывает непроверяемую ошибку!
        return new
                UserDetailsImpl(usersRepository.findOneByLogin(username)
                .orElseThrow(IllegalArgumentException::new));
    }
}
