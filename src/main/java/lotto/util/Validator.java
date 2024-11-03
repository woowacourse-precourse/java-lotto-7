package lotto.util;

import static lotto.constant.message.ErrorMessage.*;
import static lotto.constant.core.ValidatorConstant.*;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static void validateLottoPurchaseAmount(Integer lottoAmount) {
        validateNonNegative(lottoAmount);
        validateMultiple(lottoAmount);
    }

    public static void validateWinningTicket(List<Integer> winningTicket) {
        List<Integer> validatedWinningTicket = new ArrayList<>();
        for (Integer winningNumber : winningTicket) {
            validateNoDuplicate(validatedWinningTicket, winningNumber);
            validateRange(winningNumber);
            validatedWinningTicket.add(winningNumber);
        }
        validateSize(validatedWinningTicket);
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        validateNoDuplicate(winningNumbers, bonusNumber);
        validateRange(bonusNumber);
    }

    private static void validateNonNegative(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException(INVALID_NEGATIVE_NUMBER.getMessage());
        }
    }

    private static void validateMultiple(Integer number) {
        if ((number % LOTTO_PRICE.getIntegerValue()) != 0) {
            throw new IllegalArgumentException(INVALID_MULTIPLE_AMOUNT.getMessage(LOTTO_PRICE.getIntegerValue()));
        }
    }

    private static void validateNoDuplicate(List<Integer> numbers, Integer number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void validateRange(Integer number) {
        if ((number < MIN_LOTTO_NUMBER.getIntegerValue()) || (number > MAX_LOTTO_NUMBER.getIntegerValue())) {
            throw new IllegalArgumentException(
                    OUT_OF_RANGE.getMessage(MIN_LOTTO_NUMBER.getIntegerValue(), MAX_LOTTO_NUMBER.getIntegerValue()));
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getIntegerValue()) {
            throw new IllegalArgumentException(
                    INVALID_WINNING_NUMBER_COUNT.getMessage(LOTTO_NUMBER_COUNT.getIntegerValue()));
        }
    }
}
