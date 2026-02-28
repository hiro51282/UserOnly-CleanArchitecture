package useronly.domain;

import java.util.Objects;
import java.util.Set;

public final class UserName {

    // なぜ final？
    // 値オブジェクトは不変であるべき。
    private final String value;

    public UserName(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("UserName cannot be blank");
        }
        // なぜ trim する？
        // ドメインで正規化するかは設計判断
        this.value = value.trim();
    }

    public String value() {
        return value;
    }

    // なぜ equals/hashCode が重要？
    // 将来：
    // Set
    // Map
    // 重複判定
    // で使うから。
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof UserName))
            return false;
        UserName userName = (UserName) o;
        return value.equals(userName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}