package lotto.service;

import lotto.util.Constant;
import lotto.util.ErrorCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<String> splittedWinningNumbers = Arrays.asList(winningNumbers.split(","));
        Set<Integer> kindOfNumbers = new HashSet<>();

        for (String winningNumber : splittedWinningNumbers) {
            if (!winningNumber.matches(Constant.BALL_NUMBER_RANGE_CHECK_REGEX)) {
                throw ErrorCode.INVALID_WINNING_NUMBER.exception();
            }

            kindOfNumbers.add(Integer.parseInt(winningNumber.strip()));
        }

        if (kindOfNumbers.size() != 6) {
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
