package lotto.service.impl;

import lotto.domain.Money;
import lotto.domain.ProfitRate;
import lotto.domain.WinnerStatus;
import lotto.dto.ProfitRateResultDto;
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
                .orElseThrow(() -> new NullPointerException("돈이 저장되지 않았습니다!"));

        WinnerStatus winnerStatus = winnerStatusRepository.get()
                .orElseThrow(() -> new NullPointerException("당첨 정보들이 저장되지 않았습니다!"));

        ProfitRate profitRate = ProfitRate.create(money, winnerStatus);
        return profitRate.toDto();
    }
}
