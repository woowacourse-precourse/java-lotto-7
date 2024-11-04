package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MONEY_UNIT = 1000;
    private static final String ERROR_NON_NUMERIC = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private static final String ERROR_INVALID_UNIT = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static int requestPurchaseAmount() {
        while (true) {
            try {
                System.out.println(PURCHASE_AMOUNT_PROMPT);
                String purchaseAmount = Console.readLine();
                validatePurchaseAmount(purchaseAmount);
                Console.close();
                return Integer.parseInt(purchaseAmount) / MONEY_UNIT;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validatePurchaseAmount(String purchaseAmount) {
        int amount;
        try {
            amount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC);
        }

        if (amount < MONEY_UNIT || amount % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_UNIT);
        }
    }
}
