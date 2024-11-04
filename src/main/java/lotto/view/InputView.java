package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String READING_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READING_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String READING_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public String readMoney() {
        System.out.println(READING_MONEY_MESSAGE);
        return readInput();
    }

    public String readWinningNumbers() {
        System.out.println(READING_WINNING_NUMBERS_MESSAGE);
        return readInput();
    }

    public String readBonusNumber() {
        System.out.println(READING_BONUS_NUMBER_MESSAGE);
        return readInput();
    }

    private String readInput() {
        return Console.readLine();
    }
}
