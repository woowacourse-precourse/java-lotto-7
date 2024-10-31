package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String[] inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = Console.readLine().replace("\\s", "");
        return input.split(",");
    }

    public String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Console.readLine();
    }
}
