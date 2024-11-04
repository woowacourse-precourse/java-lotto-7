package lotto;

import lotto.service.LottoService;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int getValidPurchaseAmount(LottoService lottoService) {
        while (true) {
            try {
                int amount = InputView.inputPurchaseAmount();
                lottoService.calculateLottoCount(amount); // validates the amount
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
