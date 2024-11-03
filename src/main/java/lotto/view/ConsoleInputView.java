package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {
    @Override
    public String getPurchaseAmountInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public String getWinningNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분)");
        return Console.readLine();
    }

    @Override
    public String getBonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
