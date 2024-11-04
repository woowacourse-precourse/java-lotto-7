package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PayForLotto {
    public static int lottoPayout;

    public PayForLotto() {
        payForLotto();
    }

    private void payForLotto() {
        try {
            printGuideMessage();
            getUserPay();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            payForLotto();
        }
    }

    private void printGuideMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void getUserPay() {
        String userInput = readLine();
        userInput = removeBlank(userInput);
        checkIsBlank(userInput);
        checkIsOnlyNumber(userInput);
        lottoPayout = castInputType(userInput);
        checkMoneyUnit(lottoPayout);
    }

    private String removeBlank(String input) {
        return input.replaceAll(" ", "");
    }

    private int castInputType(String input) {
        return Integer.parseInt(input);
    }

    private void checkIsOnlyNumber(String input) {
        String ERROR_MESSAGE = "[ERROR] 구입금액은 숫자뿐이어야 합니다.";
        try {
            castInputType(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void checkMoneyUnit(int input) {
        String ERROR_MESSAGE = "[ERROR] 구입금액은 1,000원 단위여야 합니다.";
        int REMAINDER = input % 1000;
        if (REMAINDER != 0 || input == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void checkIsBlank(String input) {
        String ERROR_MESSAGE = "[ERROR] 금액을 입력하지 않았습니다.";
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}