package lotto.service;

import lotto.domain.LottoTicket;
import lotto.domain.Prompter;
import lotto.domain.PurchaseAmount;

public class ApplicationService {
    private final Prompter prompter;
    private final UserInputService userInputService;
    private final UserOutputService userOutputService;
    private final LottoService lottoService;

    public ApplicationService() {
        this.prompter = new Prompter();
        this.userInputService = new UserInputService(this.prompter);
        this.userOutputService = new UserOutputService(this.prompter);
        this.lottoService = new LottoService();
    }

    public void run() {
        PurchaseAmount purchaseAmount = this.userInputService.createPurchaseAmount();
        LottoTicket lottoTicket = this.lottoService.createLottoTicket(purchaseAmount);
        this.userOutputService.printPurchasedLottoTicket(lottoTicket);
    }
}
