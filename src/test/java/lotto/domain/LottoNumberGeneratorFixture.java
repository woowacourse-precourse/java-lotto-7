package lotto.domain;

import static lotto.domain.LottoConstants.COUNT_OF_LOTTO_NUMBERS;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;

public class LottoNumberGeneratorFixture {
    public static LottoNumberGenerator createLottoNumberGenerator() {
        return new LottoNumberGenerator(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_OF_LOTTO_NUMBERS);
    }
}
