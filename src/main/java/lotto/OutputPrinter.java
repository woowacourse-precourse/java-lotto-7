package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class OutputPrinter {

    public static void printLotto(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());

        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = lotto.getLottoNumbers().stream()
                    .sorted()
                    .toList();

            System.out.println(sortedNumbers);
        }
    }

    public static void printPrizeSummary(ConcurrentHashMap<Prize, Integer> prizeSummary, int lottoDrawCount) {
        System.out.println("당첨 통계\n---");
        Long sum = 0L;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        for (int i = 3; i < 7; i++) {
            Integer currentWinningNumbers =0;
            Prize prize = Prize.findByMatchingNumber(i);
            if(prizeSummary.get(prize) != null) {
                currentWinningNumbers = prizeSummary.get(prize);
                sum += (long) prize.getPrizeMoney() * currentWinningNumbers;
            }

            System.out.printf("%d개 일치 (%s원) - %d개\n", i, decimalFormat.format(prize.getPrizeMoney()) ,currentWinningNumbers);

            if (i == 5) {
                sum = printBonusResult(prizeSummary, currentWinningNumbers, sum, i, decimalFormat);
            }
        }

        double profitRate = (double) sum / (lottoDrawCount * 1000) * 100;
        double roundedProfitRate = Math.round(profitRate * 10.0) / 10.0;

        System.out.printf("총 수익률은 %.1f%%입니다.", roundedProfitRate);
    }

    private static Long printBonusResult(ConcurrentHashMap<Prize, Integer> prizeSummary, Integer currentWinningNumbers,
                                 Long sum, int i, DecimalFormat decimalFormat) {
        Prize prize = Prize.findByMatchingNumber(5.5F);

        if(prizeSummary.get(prize) != null) {
            currentWinningNumbers = prizeSummary.get(prize);
            sum += (long) prize.getPrizeMoney() * currentWinningNumbers;
        }

        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", i, decimalFormat.format(prize.getPrizeMoney()) ,
                currentWinningNumbers);

        return sum;
    }

}
