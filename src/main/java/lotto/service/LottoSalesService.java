package lotto.service;

import static lotto.controller.ErrorMessages.INVALID_UNIT_OF_PAID_AMOUNT;

import java.util.ArrayList;
import java.util.List;
import lotto.model.customer.Customer;
import lotto.dto.LottoDto;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoNumberGenerator;
import lotto.model.lotto.LottoTicket;

public class LottoSalesService {

    private static final int PRICE_OF_LOTTO_TICKET = 1000;

    public Customer sellLottoToNewCustomer(int paidAmount) {
        validatePaidAmount(paidAmount);

        int amountOfLottoTicket = paidAmount / PRICE_OF_LOTTO_TICKET;
        List<LottoTicket> tickets = issueLottoTickets(amountOfLottoTicket);

        return new Customer(paidAmount, tickets);
    }

    public List<LottoDto> getIssuedLottoNumbersOf(Customer customer) {
        List<Lotto> lottos = customer.getLottoTickets().stream()
                .map(LottoTicket::getLotto).toList();
        return lottos.stream().map(lotto -> new LottoDto(lotto.getNumbers())).toList();
    }

    private List<LottoTicket> issueLottoTickets(int amountOfLottoTicket) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < amountOfLottoTicket; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generate());
            tickets.add(new LottoTicket(lotto));
        }
        return tickets;
    }

    private void validatePaidAmount(int paidAmount) {
        if (paidAmount % PRICE_OF_LOTTO_TICKET != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_OF_PAID_AMOUNT);
        }
    }
}
