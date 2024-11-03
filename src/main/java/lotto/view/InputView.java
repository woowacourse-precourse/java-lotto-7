package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.error.CustomException;
import lotto.error.ExceptionMessage;

public class InputView {
    private final static String LOTTO_COST_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final static OutputView outputView = new OutputView();

    public String readInput() {
        String line = Console.readLine();

        if (line.isEmpty()) {
            throw new CustomException(ExceptionMessage.ERROR_MESSAGE_INPUT_IS_EMPTY);
        }
        return line;
    }

    public String inputValue(String inputMessage) {
        while (true) {
            try {
                outputView.printInputDescribeMessage(inputMessage);
                return readInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputLottoCost() {
        return inputValue(LOTTO_COST_INPUT_MESSAGE);
    }

    public String inputWinningNumber() {
        return inputValue(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public String inputBonusNumber() {
        return inputValue(BONUS_NUMBER_INPUT_MESSAGE);
    }
}

