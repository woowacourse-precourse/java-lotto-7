package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoService {
    private Lotto lotto;

    public LottoService(long numberOfLottery) {
        for (int i = 0; i < numberOfLottery; i++) {
            lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    public void start() {

    }
}
