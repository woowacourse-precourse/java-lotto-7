package lotto.service;

import lotto.util.Constant;
import lotto.util.ErrorCode;

import java.util.List;

public class Validator {

    public int validateMoney(String purchaseAmount) {
        if (!purchaseAmount.matches(Constant.PURCHASE_AMOUNT_CHECK_REGEX)) {
            throw ErrorCode.INVALD_PURCHASE_AMOUNT.exception();
        }

        int money = Integer.parseInt(purchaseAmount);

        if (money < 1000 || money > 100_000) {
            throw ErrorCode.INVALD_PURCHASE_AMOUNT.exception();
        }

        if (money % 1000 != 0) {
            throw ErrorCode.INVALD_PURCHASE_AMOUNT.exception();
        }

        return money;
    }

    public void validateWinningNumbers(String winningNumbers) {
        String[] splittedWinningNumbers = winningNumbers.split(",");

        int cnt = 0;
        for (String winningNumber : splittedWinningNumbers) {
            cnt++;
            if (!winningNumber.matches(Constant.BALL_NUMBER_RANGE_CHECK_REGEX)) {
                throw ErrorCode.INVALID_WINNING_NUMBER.exception();
            }

            if (cnt > 6) { break; }
        }

        if (cnt != 6) {
            throw ErrorCode.INVALID_WINNING_NUMBER.exception();
        }
    }

    public void validateBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        if (!bonusNumber.matches(Constant.BALL_NUMBER_RANGE_CHECK_REGEX)) {
            throw ErrorCode.INVALID_BONUS_NUMBER.exception();
        }

        duplicateWithWinningNumbers(winningNumbers, bonusNumber);
    }

    private void duplicateWithWinningNumbers(List<Integer> winningNumbers, String bonusNumber) {
        int parsedBonusNumber = Integer.parseInt((bonusNumber));

        for (Integer number : winningNumbers) {
            if (number == parsedBonusNumber) {
                throw ErrorCode.DUPLICATE_BONUS_NUMBER.exception();
            }
        }
    }

}
