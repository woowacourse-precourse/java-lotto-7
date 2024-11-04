package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NEWLINE = "\n";
    private static final String ENTER_MONEY = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String enterMoney() {
        System.out.println(ENTER_MONEY);
        return inputValue();
    }

    public String enterWinningNumber() {
        System.out.println(NEWLINE + ENTER_WINNING_NUMBER);
        return inputValue();
    }

    public String enterBonusNumber() {
        System.out.println(NEWLINE + ENTER_BONUS_NUMBER);
        return inputValue();
    }

    public String inputValue() {
        return Console.readLine();
    }
}
