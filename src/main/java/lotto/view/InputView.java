package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        return input;
    }

    public String readWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        return input;
    }

    public String readBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        return input;
    }
}
