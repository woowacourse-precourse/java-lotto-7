package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return readPurchaseAmount();
    }

    private int readPurchaseAmount() {
        String input = Console.readLine();
        int purchaseAmount = parsePurchaseAmount(input);
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            return readPurchaseAmount();
        }
    }

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위여야 합니다.");
        }
    }
}
