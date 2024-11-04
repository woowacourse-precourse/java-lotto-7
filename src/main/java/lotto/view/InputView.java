package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    private static class SingletonHelper {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return InputView.SingletonHelper.INSTANCE;
    }


    public String inputPurchaseAmount() {
        System.out.println("\n구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String inputNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonus() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
