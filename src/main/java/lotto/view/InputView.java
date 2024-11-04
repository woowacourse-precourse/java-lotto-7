package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String AMOUNT_INPUT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_REQUEST_MESSAGE = "%n당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_REQUEST_MESSAGE = "%n보너스 번호를 입력해 주세요.";
    public static final String AMOUNT = "Amount";
    public static final String WINNING_NUMBER = "WinningNumber";
    public static final String BONUS_NUMBER = "BonusNumber";

    private final String requestMessage;

    public InputView(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public void showRequestMessage() {
        System.out.println(requestMessage);
    }

    public String getInput() {
        return Console.readLine();
    }
}
