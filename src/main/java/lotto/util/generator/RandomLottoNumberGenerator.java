package lotto.util.generator;

import static lotto.config.LottoInfo.LOTTO_NUMBER_SIZE;
import static lotto.config.LottoInfo.MAXIMUM_LOTTO_NUMBER;
import static lotto.config.LottoInfo.MINIMUM_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator{

    @Override
    public List<Integer> numberGenerator() {
        return Randoms.pickUniqueNumbersInRange(
                MINIMUM_LOTTO_NUMBER.getValue(),
                MAXIMUM_LOTTO_NUMBER.getValue(),
                LOTTO_NUMBER_SIZE.getValue());
    }
}
