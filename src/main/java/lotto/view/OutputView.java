package lotto.view;

import static lotto.constant.message.OutputMessage.*;

import java.util.List;

public class OutputView {

    public static void printLottoCount(Integer lottoCount) {
        System.out.println(PURCHASE_NUMBER_OUTPUT_MESSAGE.getMessage(lottoCount));
    }

    public static void printLottoTicketsDetails(List<String> lottoTickets) {
        for (String lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }
}
