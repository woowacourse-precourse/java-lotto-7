package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    private final StringBuilder sb = new StringBuilder();
    private static final String PRINT_PURCHASE_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String PRINT_WINNING_LOTTO = "당첨 통계\n---\n";
    private static final String PRINT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.\n";

    public OutputView() {}

    public void printPurchaseLottoCount(int count) {
        sb.setLength(0);
        sb.append(count).append(PRINT_PURCHASE_LOTTO_COUNT);
        System.out.println(sb);
    }

    public void printPurchaseLottos(Lottos lottos) {
        sb.setLength(0);
        for (Lotto lotto : lottos.getLottoList()) {
            sb.append(lotto.toString()).append("\n");
        }
        System.out.println(sb);
    }

    public void printWinningLotto(Lottos lottos) {
        sb.setLength(0);
        sb.append(PRINT_WINNING_LOTTO);
        int[] counts = lottos.getWinningLottoCounts();
        sb.append("3개 일치 (5,000원) - ").append(counts[3]).append("개\n");
        sb.append("4개 일치 (50,000원) - ").append(counts[4]).append("개\n");
        sb.append("5개 일치 (1,500,000원) - ").append(counts[5]).append("개\n");
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(counts[7]).append("개\n");
        sb.append("6개 일치 (2,000,000,000원) - ").append(counts[6]).append("개");

        System.out.println(sb);
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(PRINT_RATE_OF_RETURN, rateOfReturn);
    }
}
