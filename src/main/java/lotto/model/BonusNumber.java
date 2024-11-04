package lotto.model;

import lotto.exception.BonusNumberException;
import lotto.validation.BonusNumberValidator;

import java.util.List;

import static lotto.common.constant.ErrorMessage.BONUS_NUMBER_FORMAT_ERROR;
import static lotto.common.constant.ErrorMessage.WINNING_NUMBER_CONTAINS_BONUS_NUMBER;

public class BonusNumber {

    private final Integer bonusNumber;

    private BonusNumber(String userInputBonusNumber, WinningLottoNumber winningLottoNumber) {
        this.bonusNumber = parseUserInputBonusNumber(userInputBonusNumber);

        if (winningLottoNumber.isContainInWinningLottoNumber(this)) {
            throw new BonusNumberException(WINNING_NUMBER_CONTAINS_BONUS_NUMBER);
        }
    }

    public static BonusNumber of(String userInputBonusNumber, WinningLottoNumber winningLottoNumber) {
        return new BonusNumber(userInputBonusNumber, winningLottoNumber);
    }

    private Integer parseUserInputBonusNumber(String userInputBonusNumber) {
        Integer bonusNumber;
        try {
            bonusNumber = Integer.parseInt(userInputBonusNumber.trim());
        } catch (NumberFormatException e) {
            throw new BonusNumberException(BONUS_NUMBER_FORMAT_ERROR);
        }

        BonusNumberValidator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public boolean isMatchWithLottoNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
