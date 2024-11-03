package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    public String inputPurchaseAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        return Console.readLine().trim();
    }

    public String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }
}
