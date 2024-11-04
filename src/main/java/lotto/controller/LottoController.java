package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount);
        // 추후 기능 추가 예정
    }

    private List<Lotto> purchaseLottos(int amount) {
        int count = amount / Lotto.PRICE;
        OutputView.printPurchaseCount(count);
        List<Lotto> lottos = Lotto.generateLottos(count);
        OutputView.printLottos(lottos);
        return lottos;
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
