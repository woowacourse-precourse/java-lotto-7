package lotto.service;

import static lotto.constants.LottoCondition.MIN_LOTTO_NUMBER;
import static lotto.constants.LottoCondition.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoCondition.LOTTO_NUMBERS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.model.PurchasedLottos;
import lotto.model.TicketCount;

public class PickLottoService {

    public PickLottoService() {
    }

    public PurchasedLottos auto(TicketCount ticketCount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int nowIdx = 0; nowIdx < ticketCount.get(); nowIdx++) {
            purchasedLottos.add(nowIdx, new Lotto(getRandomNumbers()));
        }
        return new PurchasedLottos(purchasedLottos);
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> nowTicket = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.get(), MAX_LOTTO_NUMBER.get(),
                LOTTO_NUMBERS.get());
        Collections.sort(nowTicket);
        return nowTicket;
    }
}
