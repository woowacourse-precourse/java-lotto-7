package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.util.LottoConstants;

public class OutputView {

  public void printLottos(List<Lotto> lottos) {
    System.out.println();
    System.out.printf((LottoConstants.MESSAGE_PURCHASED_TICKETS) + "%n", lottos.size());
    for (Lotto lotto : lottos) {
      System.out.println(formatLottoNumbers(lotto));
    }
  }

  private String formatLottoNumbers(Lotto lotto) {
    return lotto.getNumbers().toString();
  }

  public void printResult(Result result, BigDecimal profitRate) {
    System.out.println();
    System.out.println(LottoConstants.MESSAGE_RESULT_STATISTICS);
    System.out.println(LottoConstants.MESSAGE_DIVIDER);

    printRankCounts(result);

    printProfitRate(profitRate);
  }

  private void printRankCounts(Result result) {
    for (Rank rank : Rank.getWinningRanks()) {
      System.out.println(formatRankCountMessage(rank, result.getRankCount(rank)));
    }
  }

  private String formatRankCountMessage(Rank rank, int count) {
    String matchMessage = rank.getMatchMessage();
    String prize = String.format(LottoConstants.FORMAT_CURRENCY, rank.getPrize());
    return String.format(LottoConstants.FORMAT_RANK_COUNT, matchMessage, prize, count);
  }

  private void printProfitRate(BigDecimal profitRate) {
    System.out.printf((LottoConstants.MESSAGE_TOTAL_PROFIT_RATE) + "%n", profitRate);
  }
}
