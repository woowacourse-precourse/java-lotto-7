package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumberInput {

    private final PromptDisplayer promptDisplayer;

    public WinningNumberInput(PromptDisplayer promptDisplayer) {
        this.promptDisplayer = promptDisplayer;
    }

    public String getNumber() {
        System.out.println();
        promptDisplayer.showLottoNumberPrompt();
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println();
        promptDisplayer.showBonusNumberPrompt();
        return Console.readLine();
    }
}
