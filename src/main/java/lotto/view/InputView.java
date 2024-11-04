package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {

    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";


    private static String getInput(String prompt) {
        System.out.println(prompt);
        return Console.readLine().trim();
    }

    public String getPurchaseAmount() {
        return getInput(PURCHASE_AMOUNT_PROMPT);
    }

    public String getWinningNumber() {
        return getInput(WINNING_NUMBER_PROMPT);
    }

    public String getBonusNumber() {
        System.out.println();
        return getInput(BONUS_NUMBER_PROMPT);
    }
}
