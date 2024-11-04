package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        int ticketCount = purchaseAmount / 1000;
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.readPurchaseAmount();
                int amount = parseNumber(input);
                validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }
}
