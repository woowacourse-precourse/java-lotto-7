package lotto.model;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = receivePurchaseAmount();

        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(new LottoGenerator(), purchaseAmount);

        LottoTicket lottoTicket = lottoTicketGenerator.generateLottoTicket();

        outputView.printLottoTicket(lottoTicket, purchaseAmount.getPurchasableLottoAmount());

        WinningNumbers winningNumbers = receiveWinningNumbers();

        BonusNumber bonusNumber = receiveBonusNumber(winningNumbers);

    }

    public PurchaseAmount receivePurchaseAmount() {
        while (true) {
            try {
                return PurchaseAmount.from(inputView.enterPurchaseAmount());
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public WinningNumbers receiveWinningNumbers() {
        while (true) {
            try {
                return WinningNumbers.from(inputView.enterWinningNumbers());
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public BonusNumber receiveBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                BonusNumber bonusNumber = BonusNumber.from(inputView.enterBonusNumbers());
                bonusNumber.checkDuplicationNumber(winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

}
