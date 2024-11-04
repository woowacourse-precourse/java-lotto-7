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
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            LottoDTO dto = lotto.toDTO();
            System.out.println(dto.getNumbers());
        }
    }

    public static void printStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Long> statistics = lottos.stream()
                .map(lotto -> getLottoRank(lotto, winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));

        System.out.println("당첨 통계\n---");
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.printf("%d개 일치%s (%s원) - %d개%n",
                        rank.getMatchCount(),
                        rank.isMatchBonus() ? ", 보너스 볼 일치" : "",
                        numberFormat.format(rank.getPrize()),
                        statistics.getOrDefault(rank, 0L));
            }
        }
        double totalPrize = statistics.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        double purchaseAmount = lottos.size() * 1000;
        double yield = (totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    private static LottoRank getLottoRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lotto.toDTO().getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean matchBonus = lotto.toDTO().getNumbers().contains(bonusNumber);
        return LottoRank.valueOf((int) matchCount, matchBonus);
    }
}