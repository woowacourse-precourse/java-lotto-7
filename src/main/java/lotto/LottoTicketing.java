package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConfig.*;
import static lotto.constant.PurchaseConfig.PURCHASE_UNIT;

public class LottoTicketing {

    public Lottos issueTickets(Purchase purchase) {
        int count = calculateTicketCount(purchase);
        List<Lotto> lottoTickets = createLottoTickets(count);
        return new Lottos(lottoTickets);
    }

    private int calculateTicketCount(Purchase purchase) {
        return purchase.getPrice() / PURCHASE_UNIT;
    }

    private List<Lotto> createLottoTickets(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> ticket = createLottoNumbers();
            lottoTickets.add(new Lotto(ticket));
        }
        return lottoTickets;
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT);
    }
}
