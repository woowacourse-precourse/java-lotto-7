package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.utils.PurchaseCalculator;

public class LottoService {
    private final PurchaseService purchaseService;
    private final LottoGeneratorService lottoGeneratorService;
    private final StatisticsService statisticsService;
    private final ProfitCalculatorService profitCalculatorService;
    private final WinningLottoService winningLottoService;
    public LottoService(PurchaseService purchaseService, LottoGeneratorService lottoGeneratorService, StatisticsService statisticsService, ProfitCalculatorService profitCalculatorService, WinningLottoService winningLottoService) {
        this.purchaseService = purchaseService;
        this.lottoGeneratorService = lottoGeneratorService;
        this.statisticsService = statisticsService;
        this.profitCalculatorService = profitCalculatorService;
        this.winningLottoService = winningLottoService;
    }

    public User purchaseLotto(String purchaseAmount) {
        Money money = purchaseService.purchaseMoney(purchaseAmount);
        int lottoCount = PurchaseCalculator.calculateLottoCount(money);
        Lottos lottos = lottoGeneratorService.generateLottos(lottoCount);
        return new User(money, lottos);
    }

    public Lotto winningLotto(String winningNumbers) {
        return winningLottoService.generateWinningLotto(winningNumbers);
    }

}
