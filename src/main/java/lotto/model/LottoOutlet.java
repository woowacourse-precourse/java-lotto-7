package lotto.model;

import static lotto.constants.LottoConstant.COUNT;
import static lotto.constants.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstant.MIN_LOTTO_NUMBER;
import static lotto.constants.LottoConstant.WON_1000;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoOutlet {

    public static LottoTicket purchaseLottoTickets(int lottoAmount) {
        int ticketCount = LottoOutlet.buyTicketsByAmount(lottoAmount);
        return generateLottoNumbersTicket(ticketCount);
    }

    private static int buyTicketsByAmount(int lottoAmounts){
        return lottoAmounts / WON_1000;
    }

    private static LottoTicket generateLottoNumbersTicket(int totalTickets) {
        List<Lotto> lottoNumbersTicket = new ArrayList<>();

        for (int i = 0; i < totalTickets; i++){
            lottoNumbersTicket.add(makeRandomNumbers());
        }

        return new LottoTicket(lottoNumbersTicket);
    }

    private static Lotto makeRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT);

        return new Lotto(randomNumbers);
    }
}
