package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.LottoConfig.LOTTO_COUNT;
import static lotto.constant.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.MIN_LOTTO_NUMBER;
import static lotto.constant.PurchaseConfig.PURCHASE_UNIT;

public class LottoTicketing {

    public Lottos issueTickets(Purchase purchase) {
        int count = calculateTicketCount(purchase);
        List<Lotto> lottoTickets = createLottoTickets(count);
        return new Lottos(lottoTickets);
    }

    private int calculateTicketCount(Purchase purchase) {
        return purchase.getCost() / PURCHASE_UNIT;
    }

    private List<Lotto> createLottoTickets(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> ticket = createLottoNumbers().stream()
                    .sorted()
                    .collect(Collectors.toList());
            lottoTickets.add(new Lotto(ticket));
        }
        return lottoTickets;
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT);
    }
}
