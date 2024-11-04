package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoDTO;
import lotto.model.LottoRank;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String MESSAGE_PURCHASED_LOTTOS = "%d개를 구매했습니다.%n";
    private static final String MESSAGE_STATISTICS_HEADER = "당첨 통계\n---";
    private static final String MESSAGE_MATCH_COUNT = "%d개 일치%s (%s원) - %d개%n";
    private static final String MESSAGE_TOTAL_YIELD = "총 수익률은 %.1f%%입니다.%n";
    private static final String BONUS_MATCH_TEXT = ", 보너스 볼 일치";

    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE = 100;
    private static final long DEFAULT_COUNT = 0L;

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf(MESSAGE_PURCHASED_LOTTOS, lottos.size());
        for (Lotto lotto : lottos) {
            LottoDTO dto = lotto.toDTO();
            System.out.println(dto.getNumbers());
        }
    }

    public static void printStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Long> statistics = calculateStatistics(lottos, winningNumbers, bonusNumber);
        printStatisticsHeader();
        printRankStatistics(statistics);
        printTotalYield(statistics, lottos.size());
    }

    private static Map<LottoRank, Long> calculateStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> getLottoRank(lotto, winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private static void printStatisticsHeader() {
        System.out.println(MESSAGE_STATISTICS_HEADER);
    }

    private static void printRankStatistics(Map<LottoRank, Long> statistics) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        for (LottoRank rank : LottoRank.values()) {
            printRankIfApplicable(rank, statistics, numberFormat);
        }
    }

    private static void printRankIfApplicable(LottoRank rank, Map<LottoRank, Long> statistics, NumberFormat numberFormat) {
        if (rank == LottoRank.NONE) {
            return;
        }
        System.out.printf(MESSAGE_MATCH_COUNT,
                rank.getMatchCount(),
                rank.isMatchBonus() ? BONUS_MATCH_TEXT : "",
                numberFormat.format(rank.getPrize()),
                statistics.getOrDefault(rank, DEFAULT_COUNT));
    }

    private static void printTotalYield(Map<LottoRank, Long> statistics, int lottoCount) {
        double totalPrize = statistics.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        double purchaseAmount = lottoCount * LOTTO_PRICE;
        double yield = (totalPrize / purchaseAmount) * PERCENTAGE;
        System.out.printf(MESSAGE_TOTAL_YIELD, yield);
    }

    private static LottoRank getLottoRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lotto.toDTO().getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean matchBonus = lotto.toDTO().getNumbers().contains(bonusNumber);
        return LottoRank.valueOf((int) matchCount, matchBonus);
    }
}
