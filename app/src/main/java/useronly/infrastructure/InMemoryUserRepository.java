package useronly.infrastructure;

import useronly.domain.*;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    private final Map<UserName, User> store = new HashMap<>();

    @Override
    public void save(User user) {
        store.put(user.getName(), user);
    }

    @Override
    public Optional<User> findByName(UserName name) {
        return Optional.ofNullable(store.get(name));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }
}