package lotto.view;

import lotto.domain.Lottos;

import java.util.List;

import static lotto.common.Constants.ERROR_PROMPT;
import static lotto.common.Constants.LOTTO_TICKET_COUNT_PROMPT;

public class OutputView {
    public static String getErrorMessage (String errorMessage) {
        return ERROR_PROMPT + errorMessage;
    }

    public void printLottos (Lottos lottos) {
        printLineBreak();
        printLottoCount(lottos.size());

        List<String> lottosToString = lottos.lottosToString();

        for (String lottoToString: lottosToString) {
            System.out.println("[" + lottoToString + "]");
        }

        printLineBreak();
    }

    private void printLottoCount (Integer lottoTicketCount) {
        System.out.println(lottoTicketCount + LOTTO_TICKET_COUNT_PROMPT);
    }

    private void printLineBreak () {
        System.out.println();
    }
}
