package lotto.model.strategy;

import static lotto.model.util.constant.LottoConstants.LOTTO_SIZE;
import static lotto.model.util.constant.LottoConstants.MAX_NUMBER;
import static lotto.model.util.constant.LottoConstants.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.lotto.Lotto;

public class RandomStrategy implements LottoStrategy{

    private RandomStrategy() {}

    public static RandomStrategy of() {
        return new RandomStrategy();
    }

    @Override
    public Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE));
    }
}
