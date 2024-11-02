package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoOutlet {

    private final static int WON_1000 = 1000;
    private final static int START_INCLUSIVE = 1;
    private final static int END_INCLUSIVE = 45;
    private final static int COUNT = 6;

    public static int buyTicketsByAmount(int lottoAmounts){
        return lottoAmounts / WON_1000;
    }

    public static LottoTicket generateLottoNumbersTicket(int totalTickets) {
        List<Lotto> lottoNumbersTicket = new ArrayList<>();

        for (int i = 0; i < totalTickets; i++){
            lottoNumbersTicket.add(new Lotto(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT)));
        }

        return new LottoTicket(lottoNumbersTicket);
    }
}
