package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.InitMessages;

public class PurchasePrintHandler {
    public void printPurchaseMessage() {
        System.out.println(InitMessages.INPUT_PURCHASE_AMOUNTS.getMessage());
    }

    public void printPurchaseAmounts(int amounts) {
        System.out.println(InitMessages.PURCHASE_AMOUNTS.getMessage(amounts));
    }

    public void printPurchaseResult(Lottos lottos) {
        for (Lotto lotto : lottos.getLottoList) {
            System.out.println(lotto.getNumbers);
        }
    }

    public void printWinningNumbers() {
        System.out.println(InitMessages.INPUT_WINNING_NUMBERS.getMessage());
    }

    public void printBonusNumbers() {
        System.out.println(InitMessages.INPUT_BONUS_NUMBER.getMessage());
    }
}
