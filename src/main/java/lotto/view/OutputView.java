package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.LottoPaper;

public class OutputView {
    public static void renderPaper(LottoPaper paper) {
        printPurchaseCount(paper);
        printLottos(paper);
    }

    private static void printPurchaseCount(LottoPaper paper) {
        System.out.printf("%d개를 구매했습니다", paper.count());
    }

    private static void printLottos(LottoPaper paper) {
        for (Lotto lotto : paper.getLottos()) {
            System.out.println(lotto.toIntList());
        }
    }
}
