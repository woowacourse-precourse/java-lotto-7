package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumberInputConsoleHandler {
    public void showBonusNumberGuideMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public int askBonusNumber() {
        String rawBonusNumber = Console.readLine();

        return Integer.parseInt(rawBonusNumber);
    }
}
