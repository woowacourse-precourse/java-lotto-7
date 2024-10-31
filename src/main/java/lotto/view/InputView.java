package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.error.ExceptionMessage;

public class InputView {
    public String readInput() {
        String line = Console.readLine();

        if (line.isEmpty()) {
            ExceptionMessage errorMessage = ExceptionMessage.ERROR_MESSAGE_INPUT_IS_EMPTY;
            throw new IllegalArgumentException(ExceptionMessage.createErrorMessage(errorMessage));
        }
        return line;
    }

    public String inputValue(String inputMessage) {
        while (true) {
            try {
                System.out.println(inputMessage);
                return readInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputLottoCost() {
        return inputValue("구입금액을 입력해 주세요.");
    }

    public String inputWinningNumber() {
        return inputValue("당첨 번호를 입력해 주세요.");
    }

    public String inputBonusNumber() {
        return inputValue("보너스 번호를 입력해 주세요.");
    }
}

