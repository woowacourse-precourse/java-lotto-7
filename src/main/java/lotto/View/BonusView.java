package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class BonusView {
    public BonusView() {}

    public String getInput() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }
}
