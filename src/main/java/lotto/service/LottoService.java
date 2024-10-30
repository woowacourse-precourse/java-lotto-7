package lotto.service;

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

    public void purchaseLotto(String purchaseAmount) {
        purchaseService.processPurchase(purchaseAmount);
    }
}
