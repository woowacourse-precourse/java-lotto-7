package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PAYMENT_INPUT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_PROMPT = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_PROMPT = "\n보너스 번호를 입력해 주세요.";

    public String readPayment() {
        System.out.println(PAYMENT_INPUT_PROMPT);

        return Console.readLine();
    }

    public String readWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_PROMPT);

        return Console.readLine();
    }

    public String readBonus() {
        System.out.println(BONUS_INPUT_PROMPT);

        return Console.readLine();
    }
}
