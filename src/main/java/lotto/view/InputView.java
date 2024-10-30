package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    public String requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
        return readWithoutTrim();
    }

    public String requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS);
        return readWithoutTrim();
    }

    public void closeConsole() {
        Console.close();
    }

    private String readWithoutTrim() {
        return Console.readLine().trim();
    }
}
