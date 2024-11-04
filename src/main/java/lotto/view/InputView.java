package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import global.errorMessage.NumberErrorMessage;

public class InputView {

    private static final String INPUT_MONEY_PROMPT = "구입금액을 선택해주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public long getUserInputMoney() {
        return parseLongInput();
    }

    public String getWinningNumbers() {
        return getInput(WINNING_NUMBERS_PROMPT);
    }

    public String getBonusNumber() {
        return getInput(BONUS_NUMBER_PROMPT);
    }

    private String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private long parseLongInput() {
        while (true) {
            try {
                return Long.parseLong(getInput(INPUT_MONEY_PROMPT));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NumberErrorMessage.NOT_A_NUMBER.getMessage());
            }
        }
    }
}