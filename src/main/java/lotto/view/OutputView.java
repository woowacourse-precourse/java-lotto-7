package lotto.view;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;
import lotto.domain.ProfitRate;

public class OutputView {

    private static final String BUY_LOTTOS_STATEMENT = "%d개를 구매했습니다.";
    private static final String PRIZE_RESULT_STATEMENT = "당첨 통계";
    private static final String SEPARATE_LINE = "---";
    private static final String EACH_PRIZE_RESULT_STANDARD = "%d개 일치 (%s원) - %d개";
    private static final String EACH_PRIZE_RESULT_WITH_BONUS_BALL = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PROFIT_RATE_STATEMENT = "총 수익률은 %.1f%%입니다.";

    public void printLottos(Lottos lottos) {
        System.out.printf(System.lineSeparator() + BUY_LOTTOS_STATEMENT + System.lineSeparator(),
                lottos.lottos().size());

        lottos.lottos().forEach(this::printEachLotto);
    }

    public void printPrizeResult(PrizeResult prizeResult, ProfitRate profitRate) {
        System.out.println(System.lineSeparator() + PRIZE_RESULT_STATEMENT
                + System.lineSeparator() + SEPARATE_LINE);

        Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(Prize.EMPTY))
                .forEach(prize -> System.out.println(makeStatement(prize, prizeResult)));

        System.out.printf(PROFIT_RATE_STATEMENT, profitRate.getProfitRate());
    }

    private void printEachLotto(Lotto lotto) {
        System.out.println(lotto.numbers());
    }

    private String makeStatement(Prize prize, PrizeResult prizeResult) {
        if (prize == Prize.FIVE_MATCH_WITH_BONUS_BALL) {
            return String.format(EACH_PRIZE_RESULT_WITH_BONUS_BALL
                    , prize.getMatchCount()
                    , String.format("%,d", prize.getPrizeMoney())
                    , prizeResult.getPrizeCount(prize));
        }

        return String.format(EACH_PRIZE_RESULT_STANDARD
                , prize.getMatchCount()
                , String.format("%,d", prize.getPrizeMoney())
                , prizeResult.getPrizeCount(prize));
    }
}
