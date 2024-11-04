package lotto.service.impl;

import static lotto.utils.ErrorMessage.NOT_SAVE_MONEY;
import static lotto.utils.ErrorMessage.NOT_SAVE_WINNER_STATUS;

import lotto.domain.Money;
import lotto.domain.ProfitRate;
import lotto.domain.WinnerStatus;
import lotto.dto.ProfitRateResultDto;
import lotto.exception.EntityNotFoundException;
import lotto.repository.SingleRepository;
import lotto.service.ProfitRateService;

public class ProfitRateServiceImpl implements ProfitRateService {

    private final SingleRepository<Money> moneyRepository;
    private final SingleRepository<WinnerStatus> winnerStatusRepository;

    public ProfitRateServiceImpl(SingleRepository<Money> moneyRepository,
                                 SingleRepository<WinnerStatus> winnerStatusRepository) {
        this.moneyRepository = moneyRepository;
        this.winnerStatusRepository = winnerStatusRepository;
    }

    @Override
    public ProfitRateResultDto calculate() {
        Money money = moneyRepository.get()
                .orElseThrow(() -> new EntityNotFoundException(NOT_SAVE_MONEY.getMessage()));

        WinnerStatus winnerStatus = winnerStatusRepository.get()
                .orElseThrow(() -> new EntityNotFoundException(NOT_SAVE_WINNER_STATUS.getMessage()));

        ProfitRate profitRate = ProfitRate.create(money, winnerStatus);
        return profitRate.toDto();
    }
}
