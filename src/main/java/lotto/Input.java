package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final InputValidator inputValidator;

    public Input(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public Integer getAmountWithMessage() {
        while (true) {
            try {
                return getValidatedAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer getValidatedAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        Integer amount = Parser.toInteger(Console.readLine());
        inputValidator.validateAmount(amount);
        return amount;
    }

    public List<Integer> getWinNumbersWithMessage() {
        while (true) {
            try {
                System.out.println(INPUT_WIN_NUMBER_MESSAGE);
                return getValidatedWinNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getValidatedWinNumbers() {
        List<Integer> winNumbers = Parser.splitByDelimiter(Console.readLine());
        inputValidator.validateWinNumber(winNumbers);
        return winNumbers;
    }
}
