package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoSummary;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String STATISTICS_START_MESSAGE = "당첨 통계\n---";
    private static final String SIZE_MESSAGE = "%d개를 구매했습니다.";
    private static final String BRACKET_FORMAT = "[%s]";
    private static final String COMMA = ", ";
    private static final String TOTAL_RATE_OF_RETURN_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final String DECIMAL_FORMAT = "0.##";

    public static void printError(String errorMessage) {
        System.out.println(ERROR_MESSAGE + errorMessage);
    }

    public static void printResult(List<Lotto> lottoTickets, LottoSummary lottoSummary) {
        printStartMessage();
        printLottoTicketSize(lottoTickets.size());
        printLottoTickets(lottoTickets);
        printResultSummary(lottoSummary);
        printRateOfReturnString(lottoSummary);
    }

    private static void printStartMessage() {
        System.out.println(STATISTICS_START_MESSAGE);
    }

    private static void printLottoTicketSize(int lottoTicketSize) {
        System.out.println(String.format(SIZE_MESSAGE, lottoTicketSize));
    }

    private static void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            String numbers = String.join(COMMA, lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.toList()));

            System.out.println(String.format(BRACKET_FORMAT, numbers));
        }
    }

    private static void printResultSummary(LottoSummary lottoSummary) {
        for (Map.Entry<LottoRank, Integer> entry : lottoSummary.getRankCounts().entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            System.out.println(String.format(rank.getMessage(), count));
        }
    }

    private static void printRateOfReturnString(LottoSummary lottoSummary) {
        double rateOfReturn = lottoSummary.getRateOfReturn();
        DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT);
        String formattedRate = df.format(rateOfReturn);
        System.out.println(String.format(TOTAL_RATE_OF_RETURN_MESSAGE, formattedRate));
    }
}
