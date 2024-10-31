package lotto.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;

public class OutputView {

  public void printLottoTickets(List<Lotto> lottos) {
    System.out.println();
    System.out.println(formatPurchaseMessage(lottos.size()));
    for (Lotto lotto : lottos) {
      System.out.println(formatLottoNumbers(lotto));
    }
  }

  private String formatPurchaseMessage(int ticketCount) {
    return ticketCount + "개를 구매했습니다.";
  }

  private String formatLottoNumbers(Lotto lotto) {
    return lotto.getNumbers().toString();
  }

  public void printResult(Result result, BigDecimal purchaseAmount) {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---");

    printRankCounts(result.getRankCounts());

    BigDecimal profitRate = calculateProfitRate(result.calculateTotalPrize(), purchaseAmount);
    printProfitRate(profitRate);
  }

  private void printRankCounts(Map<Rank, Integer> rankCounts) {
    System.out.println(formatRankCountMessage(Rank.FIFTH, rankCounts.getOrDefault(Rank.FIFTH, 0)));
    System.out.println(formatRankCountMessage(Rank.FOURTH, rankCounts.getOrDefault(Rank.FOURTH, 0)));
    System.out.println(formatRankCountMessage(Rank.THIRD, rankCounts.getOrDefault(Rank.THIRD, 0)));
    System.out.println(formatRankCountMessage(Rank.SECOND, rankCounts.getOrDefault(Rank.SECOND, 0)));
    System.out.println(formatRankCountMessage(Rank.FIRST, rankCounts.getOrDefault(Rank.FIRST, 0)));
  }

  private String formatRankCountMessage(Rank rank, int count) {
    String matchMessage = getMatchMessage(rank);
    String prize = formatPrize(rank.getPrize());
    return matchMessage + " (" + prize + ") - " + count + "개";
  }

  private String getMatchMessage(Rank rank) {
    switch (rank) {
      case FIRST:
        return "6개 일치";
      case SECOND:
        return "5개 일치, 보너스 볼 일치";
      case THIRD:
        return "5개 일치";
      case FOURTH:
        return "4개 일치";
      case FIFTH:
        return "3개 일치";
      default:
        return "";
    }
  }

  private String formatPrize(long prize) {
    return String.format("%,d원", prize);
  }

  private BigDecimal calculateProfitRate(long totalPrize, BigDecimal purchaseAmount) {
    if (purchaseAmount.compareTo(BigDecimal.ZERO) == 0) {
      return BigDecimal.ZERO;
    }
    BigDecimal profitRate = BigDecimal.valueOf(totalPrize)
        .divide(purchaseAmount, 2, RoundingMode.HALF_UP)
        .multiply(BigDecimal.valueOf(100))
        .setScale(1, RoundingMode.HALF_UP);
    return profitRate;
  }

  private void printProfitRate(BigDecimal profitRate) {
    System.out.println("총 수익률은 " + profitRate + "%입니다.");
  }
}
