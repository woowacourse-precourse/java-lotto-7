package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView implements InputViewInterface {
    @Override
    public int inputPurchaseAmount() {
        return Integer.parseInt(readUserInput());
    }

    @Override
    public String inputWinningNumbers() {
        return readUserInput();
    }

    @Override
    public int inputBonusNumber() {
        return Integer.parseInt(readUserInput());
    }

    private String readUserInput() {
       return readLine();
    }
}
