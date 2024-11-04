package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getPurchaseAmountFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmountInput = Console.readLine();
        System.out.println();
        return purchaseAmountInput;
    }

    public String getWinningNumberFromUser() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberInput = Console.readLine();
        System.out.println();
        return winningNumberInput;
    }

    public String getBonusNumberFromUser() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine();
        System.out.println();
        return bonusNumberInput;
    }

    public static void validateEmptyString(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값으로 공백은 허용하지 않습니다.");
        }
    }

}
