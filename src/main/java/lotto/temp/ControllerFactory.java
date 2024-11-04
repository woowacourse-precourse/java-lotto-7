package lotto.temp;

import lotto.controller.BonusNumberController;
import lotto.controller.LottoController;
import lotto.controller.PurchaseController;
import lotto.controller.RankCalculatorController;
import lotto.controller.WinningNumberGenerationController;
import lotto.model.LottoGenerator;
import lotto.model.RankCalculator;
import lotto.model.WinningNumber;
import lotto.model.WinningNumberGenerator;
import lotto.service.TicketService;
import lotto.util.CommonIo;

public class ControllerFactory {
    private final IoComponent ioComponent;
    private final TicketService ticketService;
    private final LottoGenerator lottoGenerator;
    private final RankCalculator rankCalculator;
    private final WinningNumberGenerator winningNumberGenerator;

    private ControllerFactory(IoComponent ioComponent, TicketService ticketService, LottoGenerator lottoGenerator, RankCalculator rankCalculator, WinningNumberGenerator winningNumberGenerator) {
        this.ioComponent = ioComponent;
        this.ticketService = ticketService;
        this.lottoGenerator = lottoGenerator;
        this.rankCalculator = rankCalculator;
        this.winningNumberGenerator = winningNumberGenerator;
    }

    public static ControllerFactory createFactory() {
        IoComponent ioComponent = new IoComponent(new CommonIo());
        TicketService ticketService = new TicketService();
        LottoGenerator lottoGenerator = new LottoGenerator();
        RankCalculator rankCalculator = new RankCalculator();
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
        return new ControllerFactory(ioComponent, ticketService, lottoGenerator, rankCalculator, winningNumberGenerator);
    }

    public BonusNumberController createBonusNumberController() {
        return new BonusNumberController(ioComponent);
    }

    public LottoController createLottoController() {
        return new LottoController(ticketService, lottoGenerator);
    }

    public PurchaseController createPurchaseController() {
        return new PurchaseController(ticketService, ioComponent);
    }

    public RankCalculatorController createRankCalculatorController(WinningNumber winningNumber) {
        return new RankCalculatorController(winningNumber, ioComponent, rankCalculator);
    }

    public WinningNumberGenerationController createWinningNumberController() {
        return new WinningNumberGenerationController(winningNumberGenerator, ioComponent);
    }
}
