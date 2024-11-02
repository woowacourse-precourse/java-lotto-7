package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String amountInput = Console.readLine().trim();
        validateAmountInput(amountInput);

        int amount = Integer.parseInt(amountInput);
    }

    private static void validateAmountInput(String amountInput) {
        if (!amountInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        if (Integer.parseInt(amountInput) % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액 단위는 1000원 단위 이상이어야 합니다.");
        }
    }
}
