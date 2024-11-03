package lotto.model;

import static lotto.constants.LottoConstant.WON_1000;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.randomNumberMaker.LottoNumberMaker;

public class LottoOutlet {

    public static LottoTicket purchaseLottoTickets(int lottoAmount) {
        int ticketCount = buyTicketsByAmount(lottoAmount);
        return generateLottoNumbersTicket(ticketCount);
    }

    private static int buyTicketsByAmount(int lottoAmounts) {
        return lottoAmounts / WON_1000;
    }

    private static LottoTicket generateLottoNumbersTicket(int totalTickets) {
        List<Lotto> lottoNumbersTicket = new ArrayList<>();

        for (int i = 0; i < totalTickets; i++) {
            lottoNumbersTicket.add(LottoNumberMaker.makeRandomNumbers());
        }

        return new LottoTicket(lottoNumbersTicket);
    }
}
