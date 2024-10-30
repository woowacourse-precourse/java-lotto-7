package lotto.io.input.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.io.input.GameInput;

public class InputConsole implements GameInput {

    @Override
    public String getPurchaseAmountInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public String getWinningNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요 (쉼표로 구분된 6개의 숫자):");
        return Console.readLine();
    }

    @Override
    public String getBonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
