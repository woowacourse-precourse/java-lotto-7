package lotto.domain;

import lotto.validation.Validation;

import java.util.List;

import static lotto.validation.Validation.*;

public class LottoPrize {

    private final static Integer LOTTO_START_NUMBER = 1;
    private final static Integer LOTTO_END_NUMBER = 45;
    private final static Integer LOTTO_MAX_LENGTH = 6;

    private final List<Integer> lottoPrizeNumbers;

    public LottoPrize(List<Integer> lottoPrizeNumbers) {
        validate(lottoPrizeNumbers);
        this.lottoPrizeNumbers = lottoPrizeNumbers;
    }

    private void validate(List<Integer> lottoPrizeNumbers) {
        checkLottoSize(lottoPrizeNumbers, LOTTO_MAX_LENGTH);
        checkLottoDuplicate(lottoPrizeNumbers);
        checkLottoNumberRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, lottoPrizeNumbers);
    }

    public List<Integer> getLottoPrizeNumbers() {
        return lottoPrizeNumbers;
    }
}
