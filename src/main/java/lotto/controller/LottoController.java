package lotto.controller;

import static lotto.constant.LottoMessage.*;
import static lotto.util.StringProcessor.*;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import lotto.domain.PurchaseLotto;

public class LottoController {
    private final PurchaseLotto purchaseLotto;

    public LottoController(PurchaseLotto purchaseLotto) {
        this.purchaseLotto = purchaseLotto;
    }

    public void run() {
        try {
            purchaseLotto();
        } catch (IllegalArgumentException e) {
            print(e.getMessage());
        }
    }

    private void purchaseLotto() {
        String rawInput = requestInput(INPUT_PURCHASE_AMOUNT.getMessage());
        int purchaseAmount = convertInput(rawInput);
        int purchaseCount = calculatePurchaseCount(purchaseAmount);
        issueLottoTickets(purchaseCount);
        printPurchaseCount(purchaseCount);
        print(purchaseLotto.getLottoNumber());
    }

    private int convertInput(String input) {
        validateInput(input);
        return integerConverter(removeCommas(input));
    }

    private int calculatePurchaseCount(int amount) {
        return purchaseLotto.setPurchaseCount(amount);
    }

    private void issueLottoTickets(int count) {
        purchaseLotto.issueLotto(count);
    }


}
