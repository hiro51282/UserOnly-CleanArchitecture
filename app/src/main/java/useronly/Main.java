package useronly;

import useronly.application.CreateUserCommand;
import useronly.domain.User;
import useronly.infrastructure.InMemoryUserRepository;
import useronly.domain.UserRepository;

public class Main {

    public static void main(String[] args) {
        // Main → Application → Domain
        //             ↑
        //       Infrastructure
        // 依存の決定（Composition Root）
        UserRepository repository = new InMemoryUserRepository();

        CreateUserCommand command = new CreateUserCommand(repository);

        User user = command.execute("Alice");

        System.out.println("Created: " + user);
    }
}