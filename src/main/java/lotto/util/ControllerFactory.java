package lotto.util;

import lotto.controller.BonusNumberController;
import lotto.controller.LottoController;
import lotto.controller.PurchaseController;
import lotto.controller.RankCalculatorController;
import lotto.controller.WinningNumberGenerationController;
import lotto.model.WinningNumber;

public class ControllerFactory {
    private final IoComponent ioComponent;
    private final LottoComponent lottoComponent;

    public ControllerFactory(IoComponent ioComponent, LottoComponent lottoComponent) {
        this.ioComponent = ioComponent;
        this.lottoComponent = lottoComponent;
    }

    public BonusNumberController createBonusNumberController() {
        return new BonusNumberController(ioComponent);
    }

    public LottoController createLottoController() {
        return new LottoController(lottoComponent.ticketService(), lottoComponent.lottoGenerator());
    }

    public PurchaseController createPurchaseController() {
        return new PurchaseController(lottoComponent.ticketService(), ioComponent);
    }

    public RankCalculatorController createRankCalculatorController(WinningNumber winningNumber) {
        return new RankCalculatorController(winningNumber, ioComponent, lottoComponent.rankCalculator());
    }

    public WinningNumberGenerationController createWinningNumberController() {
        return new WinningNumberGenerationController(lottoComponent.winningNumberGenerator(), ioComponent);
    }
}
