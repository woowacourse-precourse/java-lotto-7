package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
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
        makeLottoNumber();
    }

    public void makeLottoNumber() {
        for (int lotto = 0; lotto < lottos.getLottosSize(); lotto++) {
            lottos.addLottoToList(lotto, new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }


}
