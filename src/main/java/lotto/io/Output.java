package lotto.io;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import lotto.Lotto;
import lotto.WinningType;

public class Output {

    private static final int TOTAL_WINNING_COUNT = 5;
    private NumberFormat numberFormat;

    public Output() {
        this.numberFormat = NumberFormat.getInstance(Locale.KOREA);
    }

    public void outputLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(this::outputLotto);
        System.out.println();
    }

    public void outputWinningResult(List<WinningType> winningTypes) {
        System.out.print("당첨 통계\n");
        System.out.print("---\n");

        int[] winningCounts = sortAndCountingWinningType(winningTypes);
        System.out.printf("%d개 일치 (%s원) - %d개\n", 3, numberFormat.format(5000), winningCounts[3]);
        System.out.printf("%d개 일치 (%s원) - %d개\n", 4, numberFormat.format(50000), winningCounts[4]);
        System.out.printf("%d개 일치 (%s원) - %d개\n", 5, numberFormat.format(1500000), winningCounts[5]);
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", 1, numberFormat.format(30000000), winningCounts[1]);
        System.out.printf("%d개 일치 (%s원) - %d개\n", 6, numberFormat.format(2000000000), winningCounts[6]);
    }

    private int[] sortAndCountingWinningType(List<WinningType> winningTypes) {
        int[] winningCounts = new int[7];

        for (WinningType winningType : winningTypes) {
            int sameCount = winningType.getSameCount();
            winningCounts[sameCount]++;
        }
        return winningCounts;
    }

    private void outputLotto(Lotto lotto) {
        System.out.printf("[%s]\n", lotto.toString());
    }

}
