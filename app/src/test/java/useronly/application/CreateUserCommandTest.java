package useronly.application;

import org.junit.jupiter.api.Test;
import useronly.domain.User;
import useronly.domain.UserRepository;
import useronly.infrastructure.InMemoryUserRepository;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserCommandTest {

    @Test
    void should_create_user_successfully() {

        UserRepository repository = new InMemoryUserRepository();
        CreateUserCommand command = new CreateUserCommand(repository);

        User user = command.execute("Alice");

        assertEquals("Alice", user.getName().value());
        assertTrue(repository.findByName(user.getName()).isPresent());
    }

    @Test
    void should_throw_exception_when_user_already_exists() {

        UserRepository repository = new InMemoryUserRepository();
        CreateUserCommand command = new CreateUserCommand(repository);

        command.execute("Alice");

        assertThrows(IllegalStateException.class, () -> {
            command.execute("Alice");
        });
    }
}
