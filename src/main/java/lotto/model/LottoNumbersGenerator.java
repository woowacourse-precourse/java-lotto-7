package lotto.model;

import static lotto.model.LottoConstants.LOTTO_NUMBERS_SIZE;
import static lotto.model.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.model.LottoConstants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumbersGenerator {

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                LOTTO_NUMBERS_SIZE
        );
    }
}
