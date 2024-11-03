package lotto.domain.utils;

import lotto.domain.model.user.Lotto;
import lotto.domain.model.user.UserPurchasedLotto;

import java.util.List;

public class TestUserPurchasedLotto {

    public static UserPurchasedLotto create(List<Lotto> lottos) {
        return UserPurchasedLotto.create(lottos);
    }
}
