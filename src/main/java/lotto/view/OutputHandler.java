package lotto.view;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;
import lotto.enums.PrizeAmount;
import lotto.model.Lotto;

public class OutputHandler {
    public void printOK(int k) {
        System.out.println(k + "개를 구매했습니다.");
    }

    public void printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int l: lotto.getNumbers()) {
            sb.append(l);
            if (lotto.getNumbers().getLast() != l) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public void printLottoS(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            printLotto(lotto);
        }
    }

    public void printWinning(Map<PrizeAmount, Integer> prizeAmounts) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Entry<PrizeAmount, Integer> pr: prizeAmounts.entrySet()) {
            printWinningAmounts(pr.getKey(), pr.getValue());
            System.out.println(" - " + pr.getValue() + "개");
        }
    }

    // 설계 다시
    public void printWinningAmounts(PrizeAmount pr, int num) {
        DecimalFormat formatter = new DecimalFormat();
        StringBuilder sb = new StringBuilder();

        sb.append(pr.getMatchCount()).append("개 일치");
        if (pr.getIsBonus().getIsBonus()) {
            sb.append(", 보너스 볼 일치");
        }
        String format = formatter.format(Long.valueOf(pr.getAmount()));
        sb.append(" (").append(format).append("원)");
        System.out.print(sb);
    }

    public void printRateOfReturn(Double rate) {
        StringBuilder sb = new StringBuilder();
        String str = String.format("%.1f", rate);
        sb.append("총 수익률은 ").append(str).append("%입니다.");
        System.out.println(sb);
    }
}
