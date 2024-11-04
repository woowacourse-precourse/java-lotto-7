package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoPrize;

public class OutputView {
    private static final String BUY_COUNT = "\n%d개를 구매했습니다.\n";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String WINNING_STATISTICS = "%d개 일치 (%s원) - %d개\n";
    private static final String BONUS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String TOTAL_RETURN = "총 수익률은 %.1f%%입니다.\n";

    public void lottoTIckets(LottoMachine lottoMachine) {
        int buy = lottoMachine.getLottoTicketSize();

        System.out.printf(BUY_COUNT, buy);

        for (Lotto lotto : lottoMachine.getLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println();
    }

    public void winningStatistics(double totalReturn) {
        System.out.println(RESULT_MESSAGE);

        for (LottoPrize value : LottoPrize.values()) {
            String prize = String.format("%,d", value.getPrize());

            if (value.getMatch() == 55) {
                System.out.printf(BONUS_MESSAGE, value.getCount());
                continue;
            }

            System.out.printf(WINNING_STATISTICS
                    , value.getMatch()
                    , prize
                    , value.getCount());
        }

        System.out.printf(TOTAL_RETURN, totalReturn);
    }
}