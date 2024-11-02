package lotto.model;

import lotto.model.draw.BonusNumber;
import lotto.model.draw.WinningLotto;
import lotto.model.draw.DrawResult;
import lotto.model.lotto.LottoGenerator;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.LottoTicketGenerator;
import lotto.model.lotto.PurchaseAmount;
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

        WinningLotto winningLotto = receiveWinningNumbers();

        BonusNumber bonusNumber = receiveBonusNumber(winningLotto);

        DrawResult drawResult = DrawResult.of(winningLotto,bonusNumber,lottoTicket);

        drawResult.generateDrawResult();

        System.out.println(drawResult.getDrawResult());

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

    public WinningLotto receiveWinningNumbers() {
        while (true) {
            try {
                return WinningLotto.from(inputView.enterWinningNumbers());
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public BonusNumber receiveBonusNumber(WinningLotto winningLotto) {
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
