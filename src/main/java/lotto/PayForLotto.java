package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PayForLotto {
    int lottoPayout;

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
        lottoPayout = castInputType(userInput);
    }

    public String removeBlank(String input) {
        return input.replaceAll(" ", "");
    }

    public int castInputType(String input) {
        return Integer.parseInt(input);
    }
}