package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ClientInput {
    public int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return purchaseAmountValidation(Console.readLine());
    }

    private int purchaseAmountValidation(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
        return Integer.parseInt(input);
    }

    public String enterWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return WinningNumberValidation(Console.readLine());
    }

    private String WinningNumberValidation(String input) {
        if (!input.matches("^([1-9]|[1-3][0-9]|4[0-5])(,([1-9]|[1-3][0-9]|4[0-5])){5}$")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 당첨 번호를 입력했습니다.");
        }
        return input;
    }

    public String enterBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return BonusNumberValidation(Console.readLine());
    }

    private String BonusNumberValidation(String input) {
        if (!input.matches("^([1-9]|[1-3][0-9]|4[0-5])$")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 보너스 번호를 입력했습니다.");
        }
        return input;
    }
}
