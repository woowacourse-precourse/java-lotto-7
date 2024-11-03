package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해 주새요.";
    private static final String REQUEST_AMOUNT = "구입금액을 입력해주세요.";
    private static final String REQUEST_NUMBER = "숫자를 입력해주세요.";
    private static final String REQUEST_INPUT_NUMBER = "0이상의 수를 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);




    private static void validateNotNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(REQUEST_INPUT_NUMBER);
        }
    }

    public static String requestNumbers() {
        return scanner.nextLine();
    }


}
