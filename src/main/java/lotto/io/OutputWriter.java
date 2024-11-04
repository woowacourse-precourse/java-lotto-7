package lotto.io;

import java.util.List;
import java.util.Map;
import lotto.vendingmachine.Lotto;
import lotto.winning.Rank;

public class OutputWriter {
    private final StringBuilder sb = new StringBuilder();

    public void write(List<Lotto> lottos) {
        sb.append("\n").append(lottos.size()).append("개를 구매했습니다.").append("\n");
        for (Lotto lotte : lottos) {
            sb.append(lotte.toString()).append("\n");
        }

        System.out.println(sb);
        sb.setLength(0);
    }

    public void printStatistics(Map<Rank, Integer> lottoStatistics, double earningsRate) {
        sb.append("\n").append("당첨 통계").append("\n").append("---").append("\n");

        for (Map.Entry<Rank, Integer> entry : lottoStatistics.entrySet()) {
            sb.append(entry.getKey().getMessage(entry.getValue())).append("\n");
        }

        sb.append("총 수익률은 ").append(earningsRate).append("%입니다.\n");

        System.out.print(sb);
    }
}
