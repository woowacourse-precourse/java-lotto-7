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

    public Integer getAmountWithGuide() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return getValidatedAmount();
    }

    private Integer getValidatedAmount() {
        Integer amount = Parser.toInteger(Console.readLine());
        inputValidator.validateAmount(amount);
        return amount;
    }

    public Lotto getWinNumbersWithGuide() {
        System.out.println(INPUT_WIN_NUMBER_MESSAGE);
        return new Lotto(getWinNumbers());
    }

    private List<Integer> getWinNumbers() {
        return Parser.splitByDelimiter(Console.readLine());
    }

    public WinningNumbers getBonusNumberWithGuide(Lotto lotto) {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return new WinningNumbers(lotto, getValidatedBonusNumber());
    }

    private Integer getValidatedBonusNumber() {
        return Parser.toInteger(Console.readLine());
    }
}
