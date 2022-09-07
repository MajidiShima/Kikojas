package com.kurdestan.shwens.user;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserIService {
    private final UserRepository repository;


    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        User lastSave = getById(user.getId());
        lastSave.setName(user.getName());
        lastSave.setPassword(user.getPassword());
        lastSave.setEmail(user.getEmail());

        return repository.save(lastSave);
    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);
    }

    @Override
    public User getById(Long id) {

        Optional<User> optUser = repository.findById(id);
        if (optUser.isEmpty()) throw new NotFoundException(("User Not Found"));

        return optUser.get();
    }
}
