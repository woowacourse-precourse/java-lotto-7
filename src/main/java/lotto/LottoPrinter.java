package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoPrinter {

    public static void printLotto(List<Lotto> issuedLottoTickets) {
        issuedLottoTickets.forEach(i -> {
            System.out.println(i.getNumbers());
        });
    }

    public static void printStatistics(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---\n");

        Map<LottoRank, Integer> rankCountMap = lottoResult.getRankCountMap();

        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
                    if (!lottoRank.equals(LottoRank.NONE)) {
                        sb.append(formatRankResult(rankCountMap, lottoRank));
                    }
                }
        );

        sb.append(String.format("총 수익률은 %s%%입니다.\n", formatRateReturn(lottoResult.getRateReturn())));

        System.out.println(sb);
    }

    private static String formatRankResult(Map<LottoRank, Integer> rankCountMap, LottoRank rank) {
        return String.format("%s (%,d원) - %d개\n",
                rank.getDescription(),
                rank.getPrize(),
                rankCountMap.getOrDefault(rank, 0)
        );
    }

    private static String formatRateReturn(double rateReturn) {
        String formatted = String.format("%.2f", rateReturn);
        return formatted.endsWith("0") ?
                formatted.substring(0, formatted.length() - 1) :
                formatted;
    }

}
