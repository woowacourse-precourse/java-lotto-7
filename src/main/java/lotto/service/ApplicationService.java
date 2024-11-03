package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Prompter;
import lotto.domain.PurchaseAmount;

public class ApplicationService {
    private final UserInputService userInputService;
    private final UserOutputService userOutputService;
    private final LottoService lottoService;

    public ApplicationService() {
        Prompter prompter = new Prompter();
        InputParser inputParser = new InputParser();
        this.userInputService = new UserInputService(prompter, inputParser);
        this.userOutputService = new UserOutputService(prompter);
        this.lottoService = new LottoService();
    }

    public void run() {
        PurchaseAmount purchaseAmount = this.userInputService.createPurchaseAmount();
        LottoTicket lottoTicket = this.lottoService.createLottoTicket(purchaseAmount);
        this.userOutputService.printPurchasedLottoTicket(lottoTicket);
        Lotto winningNumber = this.userInputService.createWinningNumber();
    }
}
