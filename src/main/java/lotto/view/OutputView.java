package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoPrize;

public class OutputView {
    private static final String BUY_COUNT = "\n%d개를 구매했습니다.\n";
    private static final String RESULT_MESSAGE = "당첨 통계\n---.";
    private static final String WINNING_STATISTICS = "%d개 일치 (%d원) - %d개\n";

    public static void lottoList(LottoMachine lottoMachine) {
        int buy = lottoMachine.getLottoTicketSize();

        System.out.printf(BUY_COUNT, buy);
        for (Lotto lotto : lottoMachine.getLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void winningStatistics(long prize) {
        System.out.println(RESULT_MESSAGE);

        for (LottoPrize value : LottoPrize.values()) {
            System.out.printf(WINNING_STATISTICS
                    , value.getMatch()
                    , value.getPrize()
                    , value.getCount());
        }

    }
}