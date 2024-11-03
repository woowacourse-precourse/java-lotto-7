package lotto.utils.randomNumberMaker;

import static lotto.constants.LottoConstant.LOTTO_NUMBER_LIMIT_COUNT;
import static lotto.constants.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Lotto;

public class LottoNumberMaker {

    public static Lotto makeRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                LOTTO_NUMBER_LIMIT_COUNT);

        return new Lotto(randomNumbers);
    }
}
