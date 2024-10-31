package lotto.service;

import static lotto.controller.ErrorMessages.INVALID_UNIT_OF_PAID_AMOUNT;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoTicket;

public class LottoService {

    private static final int PRICE_OF_LOTTO_TICKET = 1000;

    public List<LottoTicket> purchase(int paidAmount) {
        if (paidAmount % PRICE_OF_LOTTO_TICKET != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_OF_PAID_AMOUNT);
        }

        int amountOfLottoTicket = paidAmount / PRICE_OF_LOTTO_TICKET;

        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < amountOfLottoTicket; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generate());
            tickets.add(new LottoTicket(lotto));
        }

        return tickets;
    }
}
