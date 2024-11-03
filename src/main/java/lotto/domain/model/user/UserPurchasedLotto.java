package lotto.domain.model.user;

import java.util.Collections;
import java.util.List;

public class UserPurchasedLotto {
    private final List<Lotto> lottos;

    private UserPurchasedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static UserPurchasedLotto create(List<Lotto> lottos) {
        return new UserPurchasedLotto(lottos);
    }

    public List<Lotto> getUserPurchasedLotto() {
        return Collections.unmodifiableList(this.lottos);
    }
}
