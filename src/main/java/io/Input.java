package io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String ERROR = "[ERROR]";

    public static int purchaseAndGetLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                int amount = InputStringParseInt(Console.readLine());
                validateAmountForPurchaseConditions(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(ERROR + "예상치 못한 에러가 발생했습니다.");
            }
        }
    }

    private static int InputStringParseInt(String input) throws IllegalArgumentException {
        validateInputStringIsEmpty(input);
        try {
            int amount = Integer.parseInt(input);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + " 로또 구매 금액은 숫자만 가능합니다.");
        }
    }

    private static void validateAmountForPurchaseConditions(int amount) {
        if (amount > 1000) {
            throw new IllegalArgumentException(ERROR + " 로또 최소 금액은 1000원 입니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR + " 로또 구매 금액은 1000원 단위 입니다.");
        }
    }

    private static void validateInputStringIsEmpty(String input) {
        if (input.isEmpty() || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR + " 입력이 비었습니다.");
        }
    }
}
