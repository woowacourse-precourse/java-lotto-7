package lotto.view;

import lotto.dto.LottoPaper;

public class OutputView {
    public static void renderPaper(LottoPaper paper) {
        System.out.printf("%d개를 구매했습니다", paper.count());
    }
}
