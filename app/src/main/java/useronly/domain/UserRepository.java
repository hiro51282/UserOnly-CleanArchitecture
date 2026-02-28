package useronly.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    // saveはまだ重複考慮しない
    void save(User user);
       
    // Optionalで「存在しない」を明示
    Optional<User> findByName(UserName name);
    
    // Listで単純に返す（今はStreamいらない）
    List<User> findAll();
}