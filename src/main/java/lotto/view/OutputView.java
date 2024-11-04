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

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf(MESSAGE_PURCHASED_LOTTOS, lottos.size());
        for (Lotto lotto : lottos) {
            LottoDTO dto = lotto.toDTO();
            System.out.println(dto.getNumbers());
        }
    }

    public static void printStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Long> statistics = lottos.stream()
                .map(lotto -> getLottoRank(lotto, winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));

        System.out.println(MESSAGE_STATISTICS_HEADER);
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.printf(MESSAGE_MATCH_COUNT,
                        rank.getMatchCount(),
                        rank.isMatchBonus() ? BONUS_MATCH_TEXT : "",
                        numberFormat.format(rank.getPrize()),
                        statistics.getOrDefault(rank, 0L));
            }
        }
        double totalPrize = statistics.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        double purchaseAmount = lottos.size() * LOTTO_PRICE;
        double yield = (totalPrize / purchaseAmount) * 100;
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
