package util;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;

public class LottoGenerator {

    public Lotto generateLotto() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return lotto;
    }
}
