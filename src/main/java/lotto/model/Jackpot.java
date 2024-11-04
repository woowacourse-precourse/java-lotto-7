package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.Exception;

public class Jackpot {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int SIZE_LIMIT = 6;

    private final int bonusNumber;
    private final Lotto lottoNumbers;

    public Jackpot(Lotto lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        validateBonusRange(bonusNumber);
        validateBonusUnique(lottoNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusRange(int bonus) {
        if (bonus < getMinNumber()) {
            Exception.getInvalidRange();
        }
        if (bonus > getMaxNumber()) {
            Exception.getInvalidRange();
        }
    }

    private void validateBonusUnique(Lotto lottoNumbers, int bonus) {
        List<Integer> numbers = lottoNumbers.getNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            uniqueNumbers.add(number);
            if (uniqueNumbers.contains(bonus)) {
                Exception.getInvalidUniqueBonus();
            }
        }
    }

    public static int getSizeLimit() {
        return SIZE_LIMIT;
    }

    public static int getMinNumber() {
        return MIN_NUMBER;
    }

    public static int getMaxNumber() {
        return MAX_NUMBER;
    }

    public Lotto getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}