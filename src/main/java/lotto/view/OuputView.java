package lotto.view;

import lotto.domain.Lotto;

import java.util.Collection;
import java.util.List;

public class OuputView {
    private static final String PURCHASE_COUNT_PROMPT = "개를 구매했습니다.";

    public static void printLottos(List<Lotto> lottos) {
        int purchasedQuantity = lottos.size();
        System.out.println(purchasedQuantity + PURCHASE_COUNT_PROMPT);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
