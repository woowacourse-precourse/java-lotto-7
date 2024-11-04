package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.text.NumberFormat;

public class ConsoleOutputView implements OutputView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String WINNING_STATISTICS_SEPARATOR = "---";
    private static final String RETURN_ON_INVESTMENT_MESSAGE = "총 수익률은 %.1f%%입니다.%n";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String MATCH_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String BONUS_MATCH_RESULT_MESSAGE = "5개 일치, 보너스 볼 일치 (%s원) - %d개";

    @Override
    public void printLottoTicket(LottoTicket lottoTicket) {
        System.out.printf(PURCHASE_MESSAGE, lottoTicket.getLottos().size());
        for (Lotto lotto : lottoTicket.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    @Override
    public void printWinningStatistics(LottoResult lottoResult) {
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(WINNING_STATISTICS_SEPARATOR);

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }

            String resultMessage = formatResultMessage(rank, lottoResult.getWinningResults().get(rank));
            System.out.println(resultMessage);
        }
    }

    @Override
    public void printReturnOnInvestment(double returnOnInvestment) {
        System.out.printf(RETURN_ON_INVESTMENT_MESSAGE, returnOnInvestment);
    }

    @Override
    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE_PREFIX + errorMessage);
    }

    private String formatResultMessage(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            return String.format(BONUS_MATCH_RESULT_MESSAGE,
                    NumberFormat.getInstance().format(rank.getPrizeMoney()), count);
        }
        return String.format(MATCH_RESULT_MESSAGE,
                rank.getMatchCount(), NumberFormat.getInstance().format(rank.getPrizeMoney()), count);
    }
}
