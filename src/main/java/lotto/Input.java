package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    private static final String INPUT_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_GUIDE = "보너스 번호를 입력해 주세요.";
    private final InputValidator inputValidator;
    private final View view;

    public Input(InputValidator inputValidator, View view) {
        this.inputValidator = inputValidator;
        this.view = view;
    }

    public Integer getAmountWithGuide() {
        view.guide(INPUT_AMOUNT_GUIDE);
        return getValidatedAmount();
    }

    private Integer getValidatedAmount() {
        Integer amount = StringParser.toInteger(Console.readLine());
        inputValidator.validateAmount(amount);
        return amount;
    }

    public Lotto getWinNumbersWithGuide() {
        view.guide(INPUT_WINNING_NUMBERS_GUIDE);
        return new Lotto(getWinNumbers());
    }

    private List<Integer> getWinNumbers() {
        return StringParser.splitByDelimiter(Console.readLine());
    }

    public WinningNumbers getBonusNumberWithGuide(Lotto lotto) {
        view.guide(INPUT_BONUS_NUMBER_GUIDE);
        return new WinningNumbers(lotto, getValidatedBonusNumber());
    }

    private Integer getValidatedBonusNumber() {
        return StringParser.toInteger(Console.readLine());
    }
}
