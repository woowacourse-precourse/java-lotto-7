package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private LottoTickets purchasedTickets;
    private WinningLotto winningLotto;

    public void start() {
        try {
            int purchaseAmount = inputPurchaseAmount();
            generateLottoTickets(purchaseAmount);
            inputWinningNumbers();
            displayResult(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }

    }

    private int inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumericInput(input);
        int amount = Integer.parseInt(input);
        validatePurChaseAmount(amount);
        return amount;
    }

    private void validatePurChaseAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다");
        }
    }

    private void validateNumericInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다");
        }
    }


}
