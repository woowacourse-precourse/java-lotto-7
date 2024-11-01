package lotto.service;

import lotto.Exception.MoneyException;
import lotto.Exception.MoneyExceptionType;
import lotto.model.Lotto;
import lotto.utils.LottoRules;

import java.util.ArrayList;
import java.util.List;

import static lotto.Exception.MoneyExceptionType.*;
import static lotto.utils.LottoRules.LOTTO_PRICE;

public class LottoService {


    public Lotto generateLotto() {
        return new Lotto(LottoRules.pickRandomNumbers());
    }

    public List<Lotto> purchaseLottoTickets(int price) {
        List<Lotto> lottoTickets = new ArrayList<>();

        int ticketCount = price / LOTTO_PRICE ;

        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(generateLotto());
        }

        return lottoTickets;
    }
}
