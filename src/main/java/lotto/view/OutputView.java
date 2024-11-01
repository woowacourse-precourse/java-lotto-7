package lotto.view;

import static lotto.model.Rank.*;

import java.util.List;
import lotto.dto.LottoStatus;
import lotto.dto.LottoTicketStatus;
import lotto.dto.WinningStatistics;
import lotto.model.Rank;

public class OutputView {

    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    public static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    public void printError(String errorMessageContent) {
        System.out.println(ERROR_MESSAGE_PREFIX + errorMessageContent);
    }

    public void printLottoTicketStatus(LottoTicketStatus lottoTicketStatus) {
        printNewLine();
        printLottoCount(lottoTicketStatus);

        List<LottoStatus> lottoStatuses = lottoTicketStatus.getLottoStatuses();

        for(LottoStatus lottoStatus : lottoStatuses) {
            printLottoStatus(lottoStatus);
        }
    }


    public void printWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        Rank[] values = values();
        for (Rank value : values) {
            if (value == LOSE) {
                continue;
            }
            int count = winningStatistics.getLottoResult().get(value);
            System.out.println(value.getMessage() + " (" + value.getPrize() + "원) - " + count + "개");
        }
        System.out.println("총 수익률은 " + winningStatistics.getEarningRate() + "%입니다.");
    }

    private static void printLottoCount(LottoTicketStatus lottoTicketStatus) {
        List<LottoStatus> lottoStatuses = lottoTicketStatus.getLottoStatuses();
        int size = lottoStatuses.size();

        System.out.println(size + LOTTO_COUNT_MESSAGE);
    }

    private static void printLottoStatus(LottoStatus lottoStatus) {
        List<Integer> numbers = lottoStatus.getNumbers();
        System.out.println(numbers);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
