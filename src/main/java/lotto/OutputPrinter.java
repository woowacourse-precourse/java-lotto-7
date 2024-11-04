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
            System.out.printf("%d개 일치 (%s원) - %d개", i, decimalFormat.format(prize.getPrizeMoney()) ,currentWinningNumbers);
            System.out.println("\n");

            if (i == 5) {
                Float temp = 5.5F;
                prize = Prize.findByMatchingNumber(temp);
                currentWinningNumbers =0;
                if(prizeSummary.get(prize) != null) {
                    currentWinningNumbers = prizeSummary.get(prize);
                    sum += (long) prize.getPrizeMoney() * currentWinningNumbers;
                }
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개", i, decimalFormat.format(prize.getPrizeMoney()) ,currentWinningNumbers);
                System.out.println("\n");
            }
        }

        double profitRate = (double) sum / (lottoDrawCount * 1000) * 100;
        double roundedProfitRate = Math.round(profitRate * 10.0) / 10.0;

        System.out.printf("총 수익률은 %.1f%%입니다.", roundedProfitRate);
    }

}
