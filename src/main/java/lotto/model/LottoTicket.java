package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import validator.LottoValidator;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTicket;

    public LottoTicket(int numberOfTickets) {
        LottoValidator.validatePurchaseAmount(numberOfTickets * 1000);
        lottoTicket = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            lottoTicket.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTicket;
    }
}