package lotto.controller;

import lotto.enums.ErrorMessage;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MoneyController {

    public int inputMoney() {
        OutputView.printInitialMessage();
        while (true) {
            try {
                int purchasingAmount = Integer.parseInt(InputView.inputPurchasingMoney());
                Money money = new Money(purchasingAmount);
                int lottoCount = money.getLottoCount();
                OutputView.printBuyingLotto(lottoCount);
                return lottoCount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] " + ErrorMessage.INVALID_FORMAT_OF_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
