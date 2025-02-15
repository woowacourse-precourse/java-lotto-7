package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.GameConfig;
import lotto.model.Lotto;

import java.util.List;

public class RandomLotto extends Lotto {
    public RandomLotto() {
        super(Randoms.pickUniqueNumbersInRange(
                GameConfig.MIN_RANGE_NUMBER,
                GameConfig.MAX_RANGE_NUMBER,
                GameConfig.LOTTO_NUMBERS_COUNT));
    }


}
