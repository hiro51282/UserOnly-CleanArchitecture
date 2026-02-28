package useronly.domain;

public final class User {

    private final UserName name;

    public User(UserName name) {
        if (name == null) {
            throw new IllegalArgumentException("UserName cannot be null");
        }
        this.name = name;
    }

    public UserName getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User(" + name + ")";
    }
}