package lotto.presentation.view;

import lotto.domain.LottoPurchase;
import lotto.service.winning.LottoStatistics;

public class OutputView {

    public static void render(LottoPurchase purchase) {
        System.out.println(purchase.toString());
    }

    public static void render(LottoStatistics statistics) {
        System.out.println(statistics.toString());
    }
}
