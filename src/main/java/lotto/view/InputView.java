package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {}

    private static class Holder {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return Holder.INSTANCE;
    }

    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
