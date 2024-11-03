package lotto.domain;

import lotto.exception.LottoException;
import lotto.utils.LottoUtils;

import java.util.List;

import static lotto.exception.ExceptionMessage.*;

public class WinningNumber {

    private Lotto winningNumber;
    private int bonusNumber;

    public WinningNumber(List<Integer> winningNumber) {
        validate(winningNumber);

        this.winningNumber = new Lotto(winningNumber);
        this.bonusNumber = 0;
    }

    public WinningNumber(List<Integer> winningNumber, int bonusNumber) {
        validate(winningNumber);
        this.winningNumber = new Lotto(winningNumber);

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setWinningNumber(Lotto winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    public static WinningNumber to(List<Integer> winningNumbers) {
        return new WinningNumber(winningNumbers);
    }

    public void validate(List<Integer> winningNumber) {
        LottoException.throwIllegalArgumentException(
            NOT_DUPLICATE_NUMBER_IN_WINNING_NUMBER, LottoUtils.hasDuplicateNumber(winningNumber)
        );
    }

    public void validateBonusNumber(int bonusNumber) {
        LottoException.throwIllegalArgumentException(
            ONLY_NUMBER_ONE_TO_FORTY_FIVE, !isBonusNumberInRange(bonusNumber)
        );

        LottoException.throwIllegalArgumentException(
            NOT_DUPLICATE_NUMBER_IN_WINNING_NUMBER, winningNumber.contains(bonusNumber)
        );
    }

    private boolean isBonusNumberInRange(int number) {
        return number >= 1 && number <= 45;
    }
}
