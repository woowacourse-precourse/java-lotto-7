package lotto.repository;

import lotto.domain.UserLotto;

import java.util.List;

public interface UserLottoRepository {
    UserLotto save(UserLotto userLotto);

    List<UserLotto> findAll();
    void clear();
}
