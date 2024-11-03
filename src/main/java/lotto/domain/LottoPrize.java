package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.validation.Validation.*;

public class LottoPrize {

    private final static Integer LOTTO_START_NUMBER = 1;
    private final static Integer LOTTO_END_NUMBER = 45;
    private final static Integer LOTTO_MAX_LENGTH = 6;

    private final List<Integer> lottoPrizeNumbers;
    private final Integer bonusNumber;

    private LottoPrize(List<Integer> lottoPrizeNumbers, Integer bonusNumber) {
        this.lottoPrizeNumbers = lottoPrizeNumbers;
        this.bonusNumber = bonusNumber;
    }


    public static LottoPrize createLottoPrize(List<Integer> lottoPrizeNumbers) {
        validatePrizeNumbers(lottoPrizeNumbers);
        return new LottoPrize(lottoPrizeNumbers, null);
    }

    private static void validatePrizeNumbers(List<Integer> lottoPrizeNumbers) {
        checkLottoSize(lottoPrizeNumbers, LOTTO_MAX_LENGTH);
        checkLottoNumberRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, lottoPrizeNumbers);
        checkLottoDuplicate(lottoPrizeNumbers);
    }

    public static LottoPrize createLottoBonus(List<Integer> lottoPrizeNumbers, Integer bonusNumber) {
        validateBonusNumber(lottoPrizeNumbers, bonusNumber);
        return new LottoPrize(lottoPrizeNumbers, bonusNumber);
    }

    private static void validateBonusNumber(List<Integer>lottoPrizeNumbers, Integer bonusNumber) {
        checkLottoNumberRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, new ArrayList<>(List.of(bonusNumber)));
        checkDuplicateBonusNumber(lottoPrizeNumbers, bonusNumber);
    }

    public List<Integer> getLottoPrizeNumbers() {
        return lottoPrizeNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
