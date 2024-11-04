package lotto.model.generator;

import static lotto.constant.LottoGameConfig.LOTTO_NUMBERS_COUNT;
import static lotto.constant.LottoGameConfig.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MIN_LOTTO_NUMBER, LOTTO_NUMBERS_COUNT);
    }
}
