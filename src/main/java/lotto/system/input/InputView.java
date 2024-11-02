package lotto.system.input;

import lotto.system.SystemIO;

public class InputView {

    public String  showInputMoneyMessage() {
        SystemIO.showMessageToConsole("구입금액을 입력해 주세요.");
        return SystemIO.readUserInput();
    }

    public String showInputLottoNumberMessage() {
        SystemIO.showMessageToConsole("");
        SystemIO.showMessageToConsole("당첨 번호를 입력해 주세요.");
        return SystemIO.readUserInput();
    }

    public String showInputBonusNumberMessage() {
        SystemIO.showMessageToConsole("");
        SystemIO.showMessageToConsole("보너스 번호를 입력해 주세요.");
        return SystemIO.readUserInput();
    }
}
