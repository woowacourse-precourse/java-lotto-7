package lotto.command.view.output;

import java.util.Map;
import lotto.dto.MatchResult;
import lotto.dto.MatchResults;
import lotto.model.amount.ProfitRate;
import lotto.service.lotto.constant.MatchBonusEnum;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 2.
 */
public class LottoProfitCommand implements OutputCommand {
  private static final String WINNG_RESULT = "\n당첨 통계\n---\n";
  private final MatchResults matchResults;
  private final ProfitRate profitRate;

  private LottoProfitCommand (MatchResults matchResults, ProfitRate profitRate) {
    this.matchResults = matchResults;
    this.profitRate = profitRate;
  }


  public static LottoProfitCommand from(MatchResults matchResults, ProfitRate profitRate) {
    return new LottoProfitCommand(matchResults, profitRate);
  }

  @Override
  public Object execute(Object parameter) {
    return null;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append(WINNG_RESULT);

    Map<MatchResult, Integer> dashboard = matchResults.getDashboard();
    Map<MatchResult, Integer> prize = matchResults.getPrize();
    for (MatchResult matchResult : matchResults.SORTED_MATCH_RESULTS ) {
      builder.append(String.format("%d%s", matchResult.matchCount(), "개 일치"));
      if (matchResult.matchBonusEnum() == MatchBonusEnum.MATCHED){
        builder.append(", 보너스 볼 일치");
      }
      builder.append(String.format(" (%,d원)", prize.get(matchResult)))
          .append(" - ")
          .append(String.format("%,d", dashboard.get(matchResult)))
          .append("개\n");
    }
    builder.append(String.format("총 수익률은 %.1f%%입니다.", profitRate.getRate()));
    return builder.toString();
  }

}
