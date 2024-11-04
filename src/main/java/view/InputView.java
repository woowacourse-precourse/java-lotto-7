package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return Integer.parseInt(Console.readLine());
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public int inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
}