package lotto.model;

import static lotto.constant.message.ErrorMessage.*;
import static lotto.constant.core.ValidatorConstant.*;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static void validateLottoPurchaseAmount(Integer lottoAmount) {
        validateMultiple(lottoAmount);
    }

    public static void validateWinningTicket(List<Integer> winningTicket) {
        List<Integer> validatedWinningTicket = new ArrayList<>();
        for (Integer winningNumber : winningTicket) {
            validateNoDuplicate(validatedWinningTicket, winningNumber);
            validatedWinningTicket.add(winningNumber);
        }
    }

    private static void validateMultiple(Integer number) {
        if ((number % LOTTO_PRICE.getIntegerValue()) != 0) {
            throw new IllegalArgumentException(INVALID_MULTIPLE_AMOUNT.getMessage(LOTTO_PRICE.getIntegerValue()));
        }
    }

    private static void validateNoDuplicate(List<Integer> numbers, Integer number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }
}
