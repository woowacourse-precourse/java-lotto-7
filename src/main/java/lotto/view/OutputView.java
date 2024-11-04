package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputView {

    public void displayLottoTickets(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        lottos.stream()
                .map(this::formatSortedLotto)
                .forEach(System.out::println);
    }

    public void displayLottoResult(Map<LottoRank, Integer> lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        lottoResult.entrySet().stream()
                .filter(entry -> entry.getKey().getMatchCount() >= 3)
                .forEach(entry -> displayLottoRankResult(entry.getKey(), entry.getValue()));
    }

    private void displayLottoRankResult(LottoRank rank, int count) {
        String matchMessage = rank == LottoRank.SECOND
                ? String.format("%d개 일치, 보너스 볼 일치", rank.getMatchCount())
                : String.format("%d개 일치", rank.getMatchCount());

        System.out.printf("%s (%s원) - %d개%n", matchMessage, formatPrize(rank.getPrizeAmount()), count);
    }

    private String formatPrize(int prize) {
        return String.format("%,d", prize);
    }

    public void displayProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %s%%입니다.%n", formatProfitRate(profitRate));
    }

    private String formatProfitRate(double profitRate) {
        return String.format("%,.1f", Math.round(profitRate * 10) / 10.0);
    }

    public void displayErrorMessage(Exception exception) {
        System.out.println("[ERROR] " + exception.getMessage());
    }

    private String formatSortedLotto(Lotto lotto) {
        return lotto.getNumbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
