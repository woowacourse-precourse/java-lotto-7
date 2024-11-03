package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView implements UserInput {
    @Override
    public String inputPurchaseMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public String inputBonusBumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
