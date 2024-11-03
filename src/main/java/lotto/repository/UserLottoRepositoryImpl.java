package lotto.repository;

import lotto.domain.UserLotto;

import java.util.ArrayList;
import java.util.List;

public class UserLottoRepositoryImpl implements UserLottoRepository {

    private static List<UserLotto> userLottos = new ArrayList<UserLotto>();

    @Override
    public UserLotto save(UserLotto userLotto) {
        userLottos.add(userLotto);
        return userLotto;
    }

    @Override
    public List<UserLotto> findAll() {
        return userLottos;
    }

    // 테스트를 위한 리포지토리 초기화
    @Override
    public void clear() {
        userLottos.clear();
    }
}
