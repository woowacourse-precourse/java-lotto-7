package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import global.errorMessage.NumberErrorMessage;

public class InputView {
    public long getUserInputMoney() {
        return parseLongInput();
    }

    public String getWinningNumbers() {
        return getInput("당첨 번호를 입력해 주세요.");
    }

    public String getBonusNumber() {
        return getInput("보너스 번호를 입력해 주세요.");
    }

    private String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private long parseLongInput() {
        while(true) {
            try {
                return Long.parseLong(getInput("구입금액을 선택해주세요."));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NumberErrorMessage.NOT_A_NUMBER.getMessage());
            }
        }
    }
}