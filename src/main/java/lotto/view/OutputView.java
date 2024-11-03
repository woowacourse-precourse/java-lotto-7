package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;

public class OutputView {

    private static final String LOTTO_TICKETS_MESSAGE = "%n%s개를 구매했습니다.%n";
    private static final String RESULT_HEADER = "\n당첨 통계";
    private static final String RESULT_DIVIDER = "---";
    private static final String FIFTH_PLACE_MESSAGE = "3개 일치 (5,000원) - %d개%n";
    private static final String FOURTH_PLACE_MESSAGE = "4개 일치 (50,000원) - %d개%n";
    private static final String THIRD_PLACE_MESSAGE = "5개 일치 (1,500,000원) - %d개%n";
    private static final String SECOND_PLACE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n";
    private static final String FIRST_PLACE_MESSAGE = "6개 일치 (2,000,000,000원) - %d개%n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.%n";

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.printf(LOTTO_TICKETS_MESSAGE, lottoTickets.get().size());
        lottoTickets.get().forEach(lotto -> System.out.println(lotto.get()));
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println(RESULT_HEADER);
        System.out.println(RESULT_DIVIDER);
        System.out.printf(FIFTH_PLACE_MESSAGE, lottoResult.get(Rank.FIFTH_PLACE));
        System.out.printf(FOURTH_PLACE_MESSAGE, lottoResult.get(Rank.FOURTH_PLACE));
        System.out.printf(THIRD_PLACE_MESSAGE, lottoResult.get(Rank.THIRD_PLACE));
        System.out.printf(SECOND_PLACE_MESSAGE, lottoResult.get(Rank.SECOND_PLACE));
        System.out.printf(FIRST_PLACE_MESSAGE, lottoResult.get(Rank.FIRST_PLACE));
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}
