package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해 주새요.";
    private static final String REQUEST_FIRST_NUMBER = "당첨 번호를 입력해주세요.";
    private static final String REQUEST_AMOUNT = "구입금액을 입력해주세요.";
    private static final String REQUEST_NUMBER = "숫자를 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);


    public static int requestAmount() {
        try {
            System.out.println(REQUEST_AMOUNT);
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(REQUEST_NUMBER);
            return requestAmount();
        }
    }

    public static String requestFirstNumbers() {
        System.out.println(REQUEST_FIRST_NUMBER);
        return scanner.nextLine();
    }

    public static int requestBonusNumber() {
        try {
            System.out.println(REQUEST_BONUS_NUMBER);
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(REQUEST_NUMBER);
            return requestAmount();
        }
    }

    public static String requestNumbers() {
        return scanner.nextLine();
    }


}
