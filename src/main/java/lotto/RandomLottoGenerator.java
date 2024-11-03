package lotto;

import static lotto.global.constant.Config.*;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public Lotto makeLotto() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBER_SIZE));
    }
}
