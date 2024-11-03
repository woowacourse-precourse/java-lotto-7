package lotto.view;

import static lotto.model.Rank.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import lotto.dto.LottoStatus;
import lotto.dto.LottoTicketStatus;
import lotto.dto.WinningStatistics;
import lotto.model.Rank;

public class OutputView {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String EARNING_RATE_MESSAGE_PREFIX = "총 수익률은 ";
    private static final String EARNING_RATE_MESSAGE_SUFFIX = "%입니다.";
    private static final String STATISTICS_START_MESSAGE = "\n당첨 통계\n---";
    private static final String PATTERN = "#0.0";

    public void printError(String errorMessageContent) {
        System.out.println(ERROR_MESSAGE_PREFIX + errorMessageContent);
    }

    public void printLottoTicketStatus(LottoTicketStatus lottoTicketStatus) {
        printNewLine();
        printLottoCount(lottoTicketStatus);

        List<LottoStatus> lottoStatuses = lottoTicketStatus.getLottoStatuses();

        for (LottoStatus lottoStatus : lottoStatuses) {
            printLottoStatus(lottoStatus);
        }
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        printStatisticsStartMessage();

        HashMap<Rank, Integer> lottoResult = winningStatistics.getLottoResult();
        double earningRate = winningStatistics.getEarningRate();

        printLottoResult(lottoResult);
        printEarningRate(earningRate);
    }

    private void printNewLine() {
        System.out.println();
    }

    private void printLottoCount(LottoTicketStatus lottoTicketStatus) {
        List<LottoStatus> lottoStatuses = lottoTicketStatus.getLottoStatuses();
        int size = lottoStatuses.size();

        System.out.println(size + LOTTO_COUNT_MESSAGE);
    }

    private void printLottoStatus(LottoStatus lottoStatus) {
        List<Integer> numbers = lottoStatus.getNumbers();
        System.out.println(numbers);
    }

    private void printStatisticsStartMessage() {
        System.out.println(STATISTICS_START_MESSAGE);
    }

    private void printLottoResult(HashMap<Rank, Integer> lottoResult) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (rank == LOSE) {
                continue;
            }
            int count = lottoResult.get(rank);
            System.out.println(rank.getMessage(count));
        }
    }

    private void printEarningRate(double earningRate) {
        BigDecimal bigEarningRate = new BigDecimal(earningRate);
        DecimalFormat df = new DecimalFormat(PATTERN);
        String result = df.format(bigEarningRate);
        System.out.println(
                EARNING_RATE_MESSAGE_PREFIX + result + EARNING_RATE_MESSAGE_SUFFIX);
    }
}
