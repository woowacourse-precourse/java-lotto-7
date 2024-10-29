package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoFactory {
    public Lotto createRandomLotto() {
        var randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }
}
