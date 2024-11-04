package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
        return readUserInput();
    }

    public String requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS_MESSAGE);
        return readUserInput();
    }

    public String requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
        return readUserInput();
    }

    private String readUserInput() {
        String input = Console.readLine();
        System.out.println();
        return input.trim();
    }
}
