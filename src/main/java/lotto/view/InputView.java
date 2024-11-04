package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.InputValidator;

public class InputView {

    private static final String AMOUNT_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_GUIDE_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_GUIDE_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    private final InputValidator validator = new InputValidator();

    public String getAmountOfMoney() {
        System.out.println(AMOUNT_INPUT_GUIDE_MESSAGE);
        String input = Console.readLine();
        validator.validateAmountOfMoney(input);

        return input;
    }

    public String getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_GUIDE_MESSAGE);
        String input = Console.readLine();
        validator.validateWinningNumbers(input);

        return input;
    }

    public String getBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_GUIDE_MESSAGE);
        String input = Console.readLine();
        validator.validateBonusNumber(input);

        return input;
    }
}
