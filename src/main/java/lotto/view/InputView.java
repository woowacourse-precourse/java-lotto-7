package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.draw_numbers.DrawNumbersBuilder;
import lotto.utils.DrawNumbersValidator;
import lotto.utils.PaymentValidator;

public class InputView {

    private final PaymentValidator paymentValidator = new PaymentValidator();
    private final DrawNumbersValidator drawNumbersValidator = new DrawNumbersValidator();

    public long getPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        String payment = readLine();
        paymentValidator.validate(payment);
        return Long.parseLong(payment);
    }

    public DrawNumbersBuilder getWinningNumbers(DrawNumbersBuilder builder) {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = readLine();
        return builder.winningNumbers(winningNumbers);
    }

    public DrawNumbersBuilder getBonusNumber(DrawNumbersBuilder builder) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine();
        return builder.bonusNumber(bonusNumber);
    }

    private String readLine() {
        return Console.readLine();
    }

}
