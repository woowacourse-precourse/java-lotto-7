package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;
import lotto.exception.ExceptionHandler;
import lotto.util.LottoValueUtil;

public class InputView {

    public int readLottoAmount() {
        try {
            String input = readLine();
            return LottoValueUtil.toLottoAmount(input);
        } catch (IllegalArgumentException e) {
            return readLottoAmount();
        }
    }

    private String readLine() {
        while (true) {
            try {
                String input = Console.readLine().trim();
                validInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                ExceptionHandler.inputException(ErrorMessage.INVALID_INPUT);
            }
        }
    }

    private void validInput(String input) throws IllegalArgumentException {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

}
