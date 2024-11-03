package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String GET_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String GET_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public String getPurchaseAmount() {
        return readLineWithPrompt(GET_PURCHASE_AMOUNT_MESSAGE);
    }

    public String getWinningNumbers() {
        return readLineWithPrompt(GET_WINNING_NUMBERS_MESSAGE);
    }

    public String getBonusNumber() {
        return readLineWithPrompt(GET_BONUS_NUMBER_MESSAGE);
    }

    private String readLineWithPrompt(String prompt) {
        System.out.println(prompt);
        return readLine().strip();
    }
}
