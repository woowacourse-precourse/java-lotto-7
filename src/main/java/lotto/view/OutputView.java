package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String PURCHASED_COUNT_MESSAGE = "개를 구매했습니다.";

    public static final void purchaseCount(int purchaseCount) {
        System.out.println();
        System.out.println(purchaseCount + PURCHASED_COUNT_MESSAGE);
    }

    public static final void lottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
