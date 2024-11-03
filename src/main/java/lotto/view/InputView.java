package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY_INFORM_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String getMoney() {
        System.out.println(INPUT_MONEY_INFORM_MESSAGE);

        String input = Console.readLine();
        return input;
    }

    public String getWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);

        String input = Console.readLine();
        return input;
    }

    public String getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);

        String input = Console.readLine();
        return input;
    }
}
