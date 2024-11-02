package lotto.model;

import static lotto.constants.LottoConstant.COUNT;
import static lotto.constants.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstant.MIN_LOTTO_NUMBER;
import static lotto.constants.LottoConstant.WON_1000;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoOutlet {

    public static int buyTicketsByAmount(int lottoAmounts){
        return lottoAmounts / WON_1000;
    }

    public static LottoTicket generateLottoNumbersTicket(int totalTickets) {
        List<Lotto> lottoNumbersTicket = new ArrayList<>();

        for (int i = 0; i < totalTickets; i++){
            lottoNumbersTicket.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT)));
        }

        return new LottoTicket(lottoNumbersTicket);
    }
}
