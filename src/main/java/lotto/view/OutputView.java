package lotto.view;

import java.util.List;
import lotto.dto.LottoStatus;
import lotto.dto.LottoTicketStatus;

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
