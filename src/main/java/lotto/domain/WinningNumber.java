package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {

    private static final String WINNING_NUMBER_DUPLICATE = "[ERROR] 로또 당첨 번호는 중복되선 안 됩니다.";
    private static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복되선 안 됩니다.";
    private static final int BONUS_NUMBER_COUNT = 1;

    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningNumber(final List<Integer> winningNumber, final int bonusNumber) {
        validateWinningNumberDuplicate(winningNumber);
        validateBonusNumberDuplicate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumberDuplicate(final List<Integer> winningNumber) {
        Set<Integer> winningNumberSet = new HashSet<>(winningNumber);
        if (winningNumberSet.size() != winningNumber.size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE);
        }
    }

    private void validateBonusNumberDuplicate(final List<Integer> winningNumber, final int bonusNumber) {
        Set<Integer> lottoNumberSet = new HashSet<>(winningNumber);
        lottoNumberSet.add(bonusNumber);
        if (lottoNumberSet.size() != winningNumber.size() + BONUS_NUMBER_COUNT) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE);
        }
    }
}
