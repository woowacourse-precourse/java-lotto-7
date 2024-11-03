package lotto.io;

import java.util.List;
import lotto.util.InitMessages;

public class PurchasePrintHandler {
    public void printPurchaseMessage() {
        System.out.println(InitMessages.INPUT_BUDGETS.getMessage());
    }

    public void printPurchaseAmounts(int amounts) {
        System.out.println(InitMessages.PURCHASE_AMOUNTS.getMessage(amounts));
    }

    public void printPurchaseResult(List<String> purchaseLotto) {
        for (String lotto : purchaseLotto) {
            System.out.println(lotto);
        }
    }

    public void printWinningNumbers() {
        System.out.println(InitMessages.INPUT_WINNING_NUMBERS.getMessage());
    }

    public void printBonusNumbers() {
        System.out.println(InitMessages.INPUT_BONUS_NUMBER.getMessage());
    }
}
