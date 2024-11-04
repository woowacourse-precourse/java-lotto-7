package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.InputViewConstant;
import lotto.model.draw_numbers.DrawNumbersBuilder;
import lotto.utils.PaymentValidator;

public class InputView {

    private final PaymentValidator paymentValidator = new PaymentValidator();

    public long getPayment() {
        System.out.println(InputViewConstant.ENTER_PAYMENT);
        String payment = readLine();
        paymentValidator.validate(payment);
        return Long.parseLong(payment);
    }

    public DrawNumbersBuilder getWinningNumbers(DrawNumbersBuilder builder) {
        System.out.println(InputViewConstant.ENTER_WINNING_NUMBERS);
        String winningNumbers = readLine();
        return builder.winningNumbers(winningNumbers);
    }

    public DrawNumbersBuilder getBonusNumber(DrawNumbersBuilder builder) {
        System.out.println(InputViewConstant.ENTER_BONUS_NUMBER);
        String bonusNumber = readLine();
        return builder.bonusNumber(bonusNumber);
    }

    private String readLine() {
        return Console.readLine();
    }

}
