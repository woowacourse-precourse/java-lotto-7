package lotto.model;

import static lotto.constant.LottoValue.LOTTO_NUMBERS_LENGTH;
import static lotto.constant.LottoValue.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoValue.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumbersGenerator {
    private static final LottoNumbersGenerator instance = new LottoNumbersGenerator();

    private LottoNumbersGenerator getInstance() {
        return getInstance();
    }

    public List<Integer> getLottoNumbers() {
        return List.copyOf(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(),
                LOTTO_NUMBERS_LENGTH.getValue()));
    }
}
