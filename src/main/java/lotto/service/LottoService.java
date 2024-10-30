package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.utils.PurchaseCalculator;

public class LottoService {
    private final PurchaseService purchaseService;
    private final LottoGeneratorService lottoGeneratorService;
    private final StatisticsService statisticsService;
    private final ProfitCalculatorService profitCalculatorService;
    public LottoService(PurchaseService purchaseService, LottoGeneratorService lottoGeneratorService, StatisticsService statisticsService, ProfitCalculatorService profitCalculatorService) {
        this.purchaseService = purchaseService;
        this.lottoGeneratorService = lottoGeneratorService;
        this.statisticsService = statisticsService;
        this.profitCalculatorService = profitCalculatorService;
    }

    public User purchaseLotto(String purchaseAmount) {
        Money money = purchaseService.validateAndCreateMoney(purchaseAmount);
        int lottoCount = PurchaseCalculator.calculateLottoCount(money);
        Lottos lottos = lottoGeneratorService.generateLottos(lottoCount);
        return new User(money, lottos);
    }

}
