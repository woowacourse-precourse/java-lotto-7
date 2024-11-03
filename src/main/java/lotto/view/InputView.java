package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String GET_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public String getPurchaseAmount() {
        return readLineWithPrompt(GET_PURCHASE_AMOUNT_MESSAGE);
    }

    private String readLineWithPrompt(String prompt) {
        System.out.println(prompt);
        return readLine().strip();
    }
}
