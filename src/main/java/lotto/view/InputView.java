package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidate;

public class InputView {
    private final InputValidate inputValidate = new InputValidate();
    private OutputView outputView = new OutputView();

    private String userInput() {
        return Console.readLine();
    }

    public int inputBonus() {
        outputView.bonusInputMessage();
        String input = userInput();
        inputValidate.bonusRangeValidate(input);
        int bonus = Integer.parseInt(input);
        return bonus;
    }
}
