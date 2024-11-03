package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_SIZE;
import static lotto.constants.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator {

    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(), LOTTO_NUMBER_SIZE.getValue());

        return new Lotto(numbers);
    }
}
