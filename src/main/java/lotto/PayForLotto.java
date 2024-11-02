package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PayForLotto {
    int lottoPayout;

    public PayForLotto() {
        payForLotto();
    }

    public void payForLotto() {
        try {
            printGuideMessage();
            getUserPay();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            payForLotto();
        }
    }

    public void printGuideMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void getUserPay() {
        String userInput = readLine();
        userInput = removeBlank(userInput);
        checkIsBlank(userInput);
        checkIsOnlyNumber(userInput);
        lottoPayout = castInputType(userInput);
        checkMoneyUnit(lottoPayout);
    }

    public String removeBlank(String input) {
        return input.replaceAll(" ", "");
    }

    public int castInputType(String input) {
        return Integer.parseInt(input);
    }

    public void checkIsOnlyNumber(String input) {
        String ERROR_MESSAGE = "[ERROR] 구입금액은 숫자뿐이어야 합니다.";
        try {
            castInputType(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public void checkMoneyUnit(int input) {
        String ERROR_MESSAGE = "[ERROR] 구입금액은 1,000원 단위여야 합니다.";
        int REMAINDER = input % 1000;
        if (REMAINDER != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public void checkIsBlank(String input) {
        String ERROR_MESSAGE = "[ERROR] 금액을 입력하지 않았습니다.";
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}