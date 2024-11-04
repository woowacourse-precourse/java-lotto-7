package lotto.entity;

import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> mainNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> mainNumbers, int bonusNumber) {
        validateMainNumbers(mainNumbers);
        validateBonusNumber(bonusNumber, mainNumbers);
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static void validateMainNumbers(List<Integer> mainNumbers) {
        validateMainNumbersCount(mainNumbers);
        validateMainNumbersDuplication(mainNumbers);
        mainNumbers.forEach(WinningNumbers::validateNumberInRange);
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> mainNumbers) {
        validateNumberInRange(bonusNumber);
        validateBonusNumberDuplication(bonusNumber, mainNumbers);
    }

    private static void validateMainNumbersCount(List<Integer> mainNumbers) {
        if (mainNumbers.size() != LottoConstants.LOTTO_NUMBERS_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }
    }

    private static void validateMainNumbersDuplication(List<Integer> mainNumbers) {
        // check if there are duplicated numbers
        if (mainNumbers.size() != mainNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private static void validateNumberInRange(int number) {
        if (number < LottoConstants.MIN_LOTTO_NUMBER.getValue() || number > LottoConstants.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.getMessage());
        }
    }

    private static void validateBonusNumberDuplication(int bonusNumber, List<Integer> mainNumbers) {
        if (mainNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getMainNumbers() {
        return mainNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
