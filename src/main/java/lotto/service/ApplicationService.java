package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;

public class ApplicationService {
    private final Prompter prompter;
    private final InputConverter inputConverter;
    private final UserInputService userInputService;
    private final UserOutputService userOutputService;
    private final LottoService lottoService;

    public ApplicationService() {
        this.prompter = new Prompter();
        this.inputConverter = new InputConverter();
        this.userInputService = new UserInputService(this.prompter, this.inputConverter);
        this.userOutputService = new UserOutputService(this.prompter);
        this.lottoService = new LottoService();
    }

    public void run() {
        PurchaseAmount purchaseAmount = this.userInputService.createPurchaseAmount();

        LottoTicket lottoTicket = this.lottoService.createLottoTicket(purchaseAmount);
        this.prompter.showBlankLine();

        this.userOutputService.printPurchasedLottoTicket(lottoTicket);

        Lotto winningNumber = this.userInputService.createWinningNumber();
        this.prompter.showBlankLine();

        BonusNumber bonusNumber = this.userInputService.createBonusNumber(winningNumber);

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumber, bonusNumber, lottoTicket);
        lottoResultCalculator.run();
        this.prompter.showBlankLine();

        this.userOutputService.printWinningStatistics(lottoResultCalculator.getWinningLottos());

        double rateOfReturn = lottoResultCalculator.getRateOfReturn(purchaseAmount);
        this.userOutputService.printRateOfReturn(rateOfReturn);
    }
}
