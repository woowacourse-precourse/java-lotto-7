package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.text.NumberFormat;

public class TestOutputView implements OutputView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String WINNING_STATISTICS_SEPARATOR = "---";
    private static final String RETURN_ON_INVESTMENT_MESSAGE = "총 수익률은 %.1f%%입니다.%n";
    private static final String MATCH_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String BONUS_MATCH_RESULT_MESSAGE = "5개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private final StringBuilder printedMessages = new StringBuilder();

    @Override
    public void printLottoTicket(LottoTicket lottoTicket) {
        printedMessages.append(String.format(PURCHASE_MESSAGE, lottoTicket.getLottos().size()));
        for (Lotto lotto : lottoTicket.getLottos()) {
            printedMessages.append(lotto.getNumbers()).append(System.lineSeparator());
        }
    }

    @Override
    public void printWinningStatistics(LottoResult lottoResult) {
        printedMessages.append(WINNING_STATISTICS_HEADER).append(System.lineSeparator());
        printedMessages.append(WINNING_STATISTICS_SEPARATOR).append(System.lineSeparator());

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }

            String resultMessage = formatResultMessage(rank, lottoResult.getWinningResults().get(rank));
            printedMessages.append(resultMessage).append(System.lineSeparator());
        }
    }

    @Override
    public void printReturnOnInvestment(double returnOnInvestment) {
        printedMessages.append(String.format(RETURN_ON_INVESTMENT_MESSAGE, returnOnInvestment));
    }

    @Override
    public void printErrorMessage(String errorMessage) {
        printedMessages.append(ERROR_MESSAGE_PREFIX).append(errorMessage).append(System.lineSeparator());
    }

    private String formatResultMessage(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            return String.format(BONUS_MATCH_RESULT_MESSAGE,
                    NumberFormat.getInstance().format(rank.getPrizeMoney()), count);
        }
        return String.format(MATCH_RESULT_MESSAGE,
                rank.getMatchCount(), NumberFormat.getInstance().format(rank.getPrizeMoney()), count);
    }

    public String getPrintedMessages() {
        return printedMessages.toString();
    }
}
