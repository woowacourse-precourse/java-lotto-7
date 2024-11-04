package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final int MINIMUM_AMOUNT = 1000;
    public static final int MAXIMUM_AMOUNT = 100000000; // 예시: 최대 구입 금액 100000000원 설정

    public static int requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return parseAndValidateAmount(input);
    }

    public static int parseAndValidateAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            validateAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static void validateAmount(int amount) {
        if (amount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 최소 1,000원 이상이어야 합니다.");
        }
        if (amount > MAXIMUM_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 너무 큽니다. 최대 100000000원까지 가능합니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
