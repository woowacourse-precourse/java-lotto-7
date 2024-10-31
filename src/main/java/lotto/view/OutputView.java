package lotto.view;

import lotto.dto.LottoTicketStatus;

public class OutputView {

    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public void printError(String errorMessageContent) {
        System.out.println(ERROR_MESSAGE_PREFIX + errorMessageContent);
    }

    public void printLottoTicketStatus(LottoTicketStatus lottoTicketStatus) {

    }
}
