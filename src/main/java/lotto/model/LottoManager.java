package lotto.model;

import lotto.model.draw.BonusNumber;
import lotto.model.draw.WinningLotto;
import lotto.model.draw.DrawResult;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.LottoTicketGenerator;
import lotto.model.lotto.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoTicketGenerator lottoTicketGenerator;

    private PurchaseAmount purchaseAmount;
    private LottoTicket lottoTicket;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;
    private DrawResult drawResult;

    public LottoManager(InputView inputView, OutputView outputView, LottoTicketGenerator lottoTicketGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public void run() {
        buyLottoTicket();
        draw();
        displayDrawStatistics();
    }

    private void buyLottoTicket() {
        purchaseAmount = receivePurchaseAmount();
        lottoTicket = lottoTicketGenerator.generateLottoTicket(purchaseAmount);
        outputView.printLottoTicket(lottoTicket, purchaseAmount.getPurchasableLottoAmount());
    }

    private void draw() {
        winningLotto = receiveWinningNumbers();
        bonusNumber = receiveBonusNumber();
        drawResult = DrawResult.of(winningLotto, bonusNumber, lottoTicket);
        drawResult.generateDrawResult();
    }

    private void displayDrawStatistics() {
        outputView.printDrawResult(drawResult);
        int totalPrizeMoney = drawResult.getTotalPrizeMoney();
        double profitPercentage = purchaseAmount.calculateProfitPercentage(totalPrizeMoney);
        outputView.printProfitPercentage(profitPercentage);
    }

    private PurchaseAmount receivePurchaseAmount() {
        while (true) {
            try {
                return PurchaseAmount.from(inputView.enterPurchaseAmount());
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private WinningLotto receiveWinningNumbers() {
        while (true) {
            try {
                return WinningLotto.from(inputView.enterWinningNumbers());
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private BonusNumber receiveBonusNumber() {
        while (true) {
            try {
                BonusNumber bonusNumber = BonusNumber.from(inputView.enterBonusNumbers());
                bonusNumber.checkDuplicationNumber(winningLotto);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

}
