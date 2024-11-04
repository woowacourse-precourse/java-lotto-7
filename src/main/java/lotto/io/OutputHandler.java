package lotto.io;

import static lotto.constant.PrintMessageConstants.PURCHASE_COUNT;

import java.util.List;
import lotto.lotto.object.Lotto;

public class OutputHandler {
    public void printPrompt(String message) {
        System.out.println(message);
    }

    public void printPurchasedLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASE_COUNT);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printLineBreak() {
        System.out.println("\n");
    }
}
