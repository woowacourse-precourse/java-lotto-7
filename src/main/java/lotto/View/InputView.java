package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Vaildator.InputValidator;

public class InputView {
    private static final String INPUT_PAYMENT = "구입 금액을 입력해 주세요: ";
    private static final String INPUT_WINNINGNUMBERS = "당첨 번호 6개를 입력해 주세요 (쉼표로 구분): ";
    private static final String INPUT_BONUSNUMBER = "보너스 번호를 입력해 주세요: ";

    public static int inputPay() {
        while (true) { // 유효한 금액이 입력될 때까지 반복
            try {
                System.out.println(INPUT_PAYMENT);
                String amount = Console.readLine();
                InputValidator.isNumeric(amount);
                InputValidator.isEmpty(amount);
                return Integer.parseInt(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNINGNUMBERS);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUSNUMBER);
        return Console.readLine();
    }
}
