package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.view.InputViewMessage;
import lotto.model.Payment;
import lotto.model.draw_numbers.builder.DrawNumbersBuilder;
import lotto.utils.PaymentValidator;

public class InputView {

    private final PaymentValidator paymentValidator = new PaymentValidator();

    public Payment getPayment() {
        System.out.println(InputViewMessage.ENTER_PAYMENT);
        return new Payment(readLine());
    }

    public DrawNumbersBuilder getWinningNumbers(DrawNumbersBuilder builder) {
        System.out.println(InputViewMessage.ENTER_WINNING_NUMBERS);
        String winningNumbers = readLine();
        return builder.winningNumbers(winningNumbers);
    }

    public DrawNumbersBuilder getBonusNumber(DrawNumbersBuilder builder) {
        System.out.println(InputViewMessage.ENTER_BONUS_NUMBER);
        String bonusNumber = readLine();
        return builder.bonusNumber(bonusNumber);
    }

    private String readLine() {
        return Console.readLine();
    }

}
