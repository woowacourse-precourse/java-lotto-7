package lotto.validator;

import java.util.List;
import lotto.exception.ExceptionUtils;
import lotto.exception.WinningNumbersExceptionMessage;

public class LottoMachineValidator {

    public static void validate(int paymentAmount, List<Integer> winningMainNumbers) {
        if (winningMainNumbers == null || winningMainNumbers.isEmpty()) {
            throw ExceptionUtils.IllegalArgument(WinningNumbersExceptionMessage.NULL_OR_EMPTY_NUMBERS);
        }
        PaymentAmountValidator.validate(paymentAmount);
    }

}
