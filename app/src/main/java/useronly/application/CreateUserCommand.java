package useronly.application;

import useronly.domain.*;

public class CreateUserCommand {

    private final UserRepository repository;

    public CreateUserCommand(UserRepository repository) {
        this.repository = repository;
    }

    public User execute(String rawName) {

        UserName name = new UserName(rawName);

        if (repository.findByName(name).isPresent()) {
            throw new IllegalStateException("User already exists: " + name);
        }

        User user = new User(name);

        repository.save(user);

        return user;
    }
}