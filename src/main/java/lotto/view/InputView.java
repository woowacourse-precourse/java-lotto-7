package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.view.InputViewMessage;
import lotto.error.SystemError;
import lotto.model.draw_numbers.DrawNumbers;
import lotto.model.payment.Payment;
import lotto.model.draw_numbers.builder.DrawNumbersBuilder;

public class InputView {

    public static final String DEFAULT_PAYMENT = "1000";
    public static final String DEFAULT_WINNING_NUMBERS = "1,2,3,4,5,6";
    public static final String DEFAULT_BONUS_NUMBER = "7";
    public static final int LIMIT_REPEAT_COUNT = 100;

    public Payment getPayment() {
        System.out.println(InputViewMessage.ENTER_PAYMENT);
        int repeatCount = 0;
        while (repeatCondition(repeatCount)) {
            repeatCount += 1;
            try {
                return new Payment(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(String.format(SystemError.MAX_RETRY_EXCEEDED.getMessage(), DEFAULT_PAYMENT));
        return new Payment(DEFAULT_PAYMENT);
    }

    public DrawNumbers getDrawNumbers() {
        DrawNumbersBuilder builder = new DrawNumbersBuilder();

        builder = buildWinningNumber(builder);
        builder = buildBonusNumber(builder);

        return builder.build();
    }

    private DrawNumbersBuilder buildWinningNumber(DrawNumbersBuilder builder) {
        int repeatCount = 0;
        while (repeatCondition(repeatCount)) {
            repeatCount += 1;
            try {
                return getWinningNumbers(builder);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(String.format(SystemError.MAX_RETRY_EXCEEDED.getMessage(), DEFAULT_WINNING_NUMBERS));
        return builder.winningNumbers(DEFAULT_WINNING_NUMBERS);
    }

    private DrawNumbersBuilder buildBonusNumber(DrawNumbersBuilder builder) {
        int repeatCount = 0;
        while (repeatCondition(repeatCount)) {
            repeatCount += 1;
            try {
                return getBonusNumber(builder);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(String.format(SystemError.MAX_RETRY_EXCEEDED.getMessage(), DEFAULT_BONUS_NUMBER));
        return builder.bonusNumber(DEFAULT_BONUS_NUMBER);
    }

    private DrawNumbersBuilder getWinningNumbers(DrawNumbersBuilder builder) {
        System.out.println(InputViewMessage.ENTER_WINNING_NUMBERS);
        String winningNumbers = readLine();
        return builder.winningNumbers(winningNumbers);
    }

    private DrawNumbersBuilder getBonusNumber(DrawNumbersBuilder builder) {
        System.out.println(InputViewMessage.ENTER_BONUS_NUMBER);
        String bonusNumber = readLine();
        return builder.bonusNumber(bonusNumber);
    }

    private boolean repeatCondition(int repeatCount) {
        return repeatCount < LIMIT_REPEAT_COUNT;
    }

    private String readLine() {
        return Console.readLine();
    }
}
