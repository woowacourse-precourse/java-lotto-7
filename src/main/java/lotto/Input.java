package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final InputValidator inputValidator;

    public Input(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public Integer getAmountWithMessage() {
        while (true) {
            try {
                System.out.println(INPUT_AMOUNT_MESSAGE);
                return getValidatedAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer getValidatedAmount() {
        Integer amount = Parser.toInteger(Console.readLine());
        inputValidator.validateAmount(amount);
        return amount;
    }

    public Lotto getWinNumberLotto() {
        while (true) {
            try {
                System.out.println(INPUT_WIN_NUMBER_MESSAGE);
                List<Integer> numbers = getWinNumbers();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getWinNumbers() {
        return Parser.splitByDelimiter(Console.readLine());
    }

    public WinLotto getBonusNumber(Lotto lotto) {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
                return new WinLotto(lotto, getValidatedBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer getValidatedBonusNumber() {
        return Parser.toInteger(Console.readLine());
    }
}
