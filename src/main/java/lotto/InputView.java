package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String askPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        String initialInput = Console.readLine();
        return initialInput;
    }

    public String askWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String initianlInput = Console.readLine();
        return initianlInput;
    }

    public String askBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String initialInput = Console.readLine();
        return initialInput;
    }
}
