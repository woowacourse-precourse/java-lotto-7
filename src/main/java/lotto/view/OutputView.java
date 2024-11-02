package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.List;

public class OutputView {
    public static void printResultBuyCount(int purchaseCount) {
        System.out.printf("%d개를 구매했습니다.\n", purchaseCount);
    }
}
