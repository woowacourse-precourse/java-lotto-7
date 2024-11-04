package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public InputView() {
    }

    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        System.out.println();
        return input;
    }

    public String inputNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        System.out.println();
        return input;
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = readLine();
        System.out.println();
        return input;
    }

}
