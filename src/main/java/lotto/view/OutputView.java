package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.TotalGain;
import lotto.domain.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LOTTO_COUNT="\n%d개를 구매했습니다.\n";
    private static final String BONUS_NUMBER_COMMAND="보너스 번호를 입력해 주세요.";
    private static final String RESULT="%d개 일치 (%d원) - %d개\n";
    private static final String WINNING_STATISTICS="당첨 통계";
    private static final String INVESTMENT="총 수익률은 %.1f%%입니다.";

    public static void printLottosInfo(List<Lotto> lottos) {
        System.out.printf(LOTTO_COUNT,lottos.size());
        for (Lotto lotto:lottos){
            String lottoStatement=lotto.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(", "));
            StringBuilder sb=new StringBuilder(lottoStatement);
            sb.insert(0,"[");
            sb.append("]");
            System.out.println(sb.toString());
        }

    }

    public static void showResult(TotalGain totalGain) {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println("---");
        for (Rank rank: totalGain.getPrizeResult().keySet()){
            int cnt=totalGain.getPrizeResult().get(rank);

            if (rank.getInfo(cnt).isBlank()){
                continue;
            }
            System.out.println(rank.getInfo(cnt));
        }
        System.out.printf(INVESTMENT, totalGain.calculateInvestment());
    }
}
