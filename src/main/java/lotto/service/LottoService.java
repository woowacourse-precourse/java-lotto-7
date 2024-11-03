package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.User;

public class LottoService {

    private final User user;
    private final Lottos lottos = new Lottos();

    public LottoService(User user) {
        this.user = user;
    }

    public void run() {
        lottos.makeLottos(user);
    }
}
