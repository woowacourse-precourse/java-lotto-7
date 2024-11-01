package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {

    private static final String INVALID_WINNING_NUMBER_COUNT = "[ERROR] 당첨 번호의 개수는 6개여야 합니다.";
    private static final String WINNING_NUMBER_IS_POSITIVE = "[ERROR] 당첨 번호는 양의 정수여야 합니다.";
    private static final String INVALID_WINNING_NUMBER_RANGE = "[ERROR] 당첨 번호는 1~45 사이의 양의 정수여야 합니다.";
    private static final String WINNING_NUMBER_DUPLICATE = "[ERROR] 로또 당첨 번호는 서로 중복되선 안 됩니다.";
    private static final String BONUS_NUMBER_IS_POSITIVE = "[ERROR] 보너스 번호는 양의 정수여야 합니다";
    private static final String INVALID_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1~45 사이의 양의 정수여야 합니다";
    private static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복되선 안 됩니다.";

    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int START_NUMBER_RANGE = 1;
    private static final int END_NUMBER_RANGE = 45;

    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningNumber(final List<String> winningNumber, final String bonusNumber) {
        validateWinningNumber(winningNumber);
        validateBonusNumber(winningNumber, bonusNumber);

        this.winningNumber = winningNumber.stream()
                .map(Integer::parseInt)
                .toList();
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getWinningNumber() {
        return this.winningNumber.stream().toList();
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateWinningNumber(final List<String> winningNumber) {
        validateWinningNumberCount(winningNumber);
        winningNumber.forEach(number -> {
            validateWinningNumberIsPositive(number);
            validateWinningNumberRange(number);
        });
        validateWinningNumberDuplicate(winningNumber);
    }

    private void validateWinningNumberCount(final List<String> winningNumber) {
        if (winningNumber.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_COUNT);
        }
    }

    private void validateWinningNumberIsPositive(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException(WINNING_NUMBER_IS_POSITIVE);
        }
    }

    private void validateWinningNumberRange(String number) {
        if (Integer.parseInt(number) < START_NUMBER_RANGE || Integer.parseInt(number) > END_NUMBER_RANGE) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE);
        }
    }

    private void validateWinningNumberDuplicate(final List<String> winningNumber) {
        Set<String> winningNumberSet = new HashSet<>(winningNumber);
        if (winningNumberSet.size() != winningNumber.size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE);
        }
    }

    private void validateBonusNumber(final List<String> winningNumber, final String bonusNumber) {
        validateBonusNumberIsPositive(bonusNumber);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicate(winningNumber, bonusNumber);
    }

    private void validateBonusNumberIsPositive(final String bonusNumber) {
        if (!bonusNumber.matches("\\d+")) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_POSITIVE);
        }
    }

    private void validateBonusNumberRange(final String bonusNumber) {
        if (Integer.parseInt(bonusNumber) < START_NUMBER_RANGE || Integer.parseInt(bonusNumber) > END_NUMBER_RANGE) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE);
        }
    }

    private void validateBonusNumberDuplicate(final List<String> winningNumber, final String bonusNumber) {
        Set<String> lottoNumberSet = new HashSet<>(winningNumber);
        if (lottoNumberSet.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE);
        }
    }
}
