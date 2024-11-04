package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBonusNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.io.input.InputConverter;
import lotto.io.input.UserInputService;
import lotto.io.output.UserOutputService;
import lotto.io.output.UserPromptService;

public class LottoApplicationProcessor {
    private final UserPromptService userPromptService;
    private final InputConverter inputConverter;
    private final UserInputService userInputService;
    private final UserOutputService userOutputService;
    private final LottoMachine lottoMachine;

    public LottoApplicationProcessor() {
        this.userPromptService = new UserPromptService();
        this.inputConverter = new InputConverter();
        this.userInputService = new UserInputService(this.userPromptService, this.inputConverter);
        this.userOutputService = new UserOutputService(this.userPromptService);
        this.lottoMachine = new LottoMachine();
    }

    public void run() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        LottoTicket lottoTicket = purchaseLottoTicket(purchaseAmount);
        Lotto winningNumber = inputWinningNumber();
        LottoBonusNumber lottoBonusNumber = inputBonusNumber(winningNumber);
        LottoResultCalculator lottoResultCalculator = displayWinningStatistics(winningNumber, lottoBonusNumber,
                lottoTicket);
        displayRateOfReturn(lottoResultCalculator, purchaseAmount);
    }

    private PurchaseAmount inputPurchaseAmount() {
        return this.userInputService.createPurchaseAmount();
    }

    private LottoTicket purchaseLottoTicket(PurchaseAmount purchaseAmount) {
        LottoTicket lottoTicket = this.lottoMachine.createLottoTicket(purchaseAmount);
        this.userPromptService.showBlankLine();
        this.userOutputService.printPurchasedLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private Lotto inputWinningNumber() {
        Lotto winningNumber = this.userInputService.createWinningNumber();
        this.userPromptService.showBlankLine();
        return winningNumber;
    }

    private LottoBonusNumber inputBonusNumber(Lotto winningNumber) {
        return this.userInputService.createBonusNumber(winningNumber);
    }

    private LottoResultCalculator displayWinningStatistics(Lotto winningNumber, LottoBonusNumber lottoBonusNumber,
                                                           LottoTicket lottoTicket) {
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningNumber, lottoBonusNumber,
                lottoTicket);
        lottoResultCalculator.run();
        this.userPromptService.showBlankLine();
        this.userOutputService.printWinningStatistics(lottoResultCalculator.getWinningLottos());
        return lottoResultCalculator;
    }

    private void displayRateOfReturn(LottoResultCalculator lottoResultCalculator, PurchaseAmount purchaseAmount) {
        double rateOfReturn = lottoResultCalculator.getRateOfReturn(purchaseAmount);
        this.userOutputService.printRateOfReturn(rateOfReturn);
    }
}
