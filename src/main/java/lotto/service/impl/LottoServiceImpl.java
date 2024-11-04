package lotto.service.impl;

import static lotto.utils.ErrorMessage.NOT_SAVE_MONEY;

import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.dto.LottoTicketsDto;
import lotto.dto.MoneyDto;
import lotto.exception.EntityNotFoundException;
import lotto.repository.SingleRepository;
import lotto.service.LottoService;

public class LottoServiceImpl implements LottoService {

    private final SingleRepository<Money> moneyRepository;
    private final SingleRepository<LottoTickets> lottoTicketsRepository;

    public LottoServiceImpl(SingleRepository<Money> moneyRepository,
                            SingleRepository<LottoTickets> lottoTicketsRepository) {
        this.moneyRepository = moneyRepository;
        this.lottoTicketsRepository = lottoTicketsRepository;
    }

    @Override
    public MoneyDto createMoney(String input) {
        Money money = Money.create(input);

        return moneyRepository.save(money)
                .toDto();
    }

    @Override
    public LottoTicketsDto generateLottoTickets() {
        Money money = moneyRepository.get()
                .orElseThrow(() -> new EntityNotFoundException(NOT_SAVE_MONEY.getMessage()));

        LottoTickets lottoTickets = LottoTickets.generate(money);

        return lottoTicketsRepository.save(lottoTickets)
                .toDto();
    }
}
