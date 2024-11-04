package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.RankResult;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printResultBuyCount(long purchaseCount) {
        System.out.printf("\n%d개를 구매했습니다.\n", purchaseCount);
    }

    public static void printLottos(Lottos lottos) {
        List<Lotto> lottoGroup = lottos.getLottos();
        printResultBuyCount(lottoGroup.size());
        lottoGroup.forEach(OutputView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }
}
