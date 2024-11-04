package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningBonus {

    private final String WINNING_NUMBERS_SHOULD_BE_BETWEEN_ONE_AND_FORTYFIVE = "[ERROR] 당첨 번호는 1~45 사이에 존재해야 합니다.";
    private final String BONUS_NUMBER_SHOULD_BE_BETWEEN_ONE_AND_FORTYFIVE = "[ERROR] 보너스 번호는 1~45 사이에 존재해야 합니다.";
    private final String WINNING_NUMBERS_MUST_NOT_BE_DUPLICATED = "[ERROR] 당첨 번호는 중복이 불가능 합니다.";
    private final String WINNING_NUMBERS_CONTAIN_BONUS_NUMBER = "[ERROR] 당첨 번호와 보너스 번호는 중복이 불가능 합니다.";

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningBonus(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(bonusNumber);
        validateDuplication(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (!isBetweenOneAndFortyFive(winningNumbers)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SHOULD_BE_BETWEEN_ONE_AND_FORTYFIVE);
        }
        if (!isDifferentNumbers(winningNumbers)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_MUST_NOT_BE_DUPLICATED);
        }
    }

    private boolean isBetweenOneAndFortyFive(List<Integer> winningNumbers){
        for (int winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                return false;
            }
        }
        return true;
    }

    private boolean isDifferentNumbers(List<Integer> winningNumbers) {
        Set<Integer> duplicateCheck = new HashSet<>(winningNumbers);
        return duplicateCheck.size() == 6;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (!isBetweenOneAndFortyFive(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_SHOULD_BE_BETWEEN_ONE_AND_FORTYFIVE);
        }
    }

    private boolean isBetweenOneAndFortyFive(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            return false;
        }
        return true;
    }

    private void validateDuplication(List<Integer> winningNumbers, int bonusNumber) {
        for (int winningNumber : winningNumbers) {
            if (winningNumber == bonusNumber) {
                throw new IllegalArgumentException(WINNING_NUMBERS_CONTAIN_BONUS_NUMBER);
            }
        }

    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
