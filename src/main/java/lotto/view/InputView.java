package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static int MONEY_UNIT = 1000;

    public int getMoneyInput() {
        String moneyInput = Console.readLine();
        validateMoneyInput(moneyInput);
        return Integer.parseInt(moneyInput);
    }

    private void validateMoneyInput(String moneyInput) {
        validateMoneyFormat(moneyInput);
        validateMoneyPositive(moneyInput);
        validateMoneyUnit(moneyInput);
    }

    private void validateMoneyFormat(String moneyInput) {
        try {
            Integer.parseInt(moneyInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 정수여야 합니다.");
        }
    }

    private void validateMoneyPositive(String moneyInput) {
        int money = Integer.parseInt(moneyInput);
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1원 이상이어야 합니다.");
        }
    }

    private void validateMoneyUnit(String moneyInput) {
        int money = Integer.parseInt(moneyInput);
        if ((money % MONEY_UNIT) != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위여야 합니다.");
        }
    }
}
