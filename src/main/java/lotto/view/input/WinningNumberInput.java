package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumberInput {

    private final PromptDisplayer promptDisplayer;

    public WinningNumberInput(PromptDisplayer promptDisplayer) {
        this.promptDisplayer = promptDisplayer;
    }

    public String getNumber() {
        promptDisplayer.showLottoNumberPrompt();
        return Console.readLine();
    }

    public String getBonusNumber() {
        promptDisplayer.showBonusNumberPrompt();
        return Console.readLine();
    }
}
