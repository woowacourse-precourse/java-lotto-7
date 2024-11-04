package lotto.controller;

import lotto.util.InputValidator;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        // 추후 기능 추가 예정
    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.inputPurchaseAmount();
                int amount = parsePurchaseAmount(input);
                InputValidator.validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }
}
