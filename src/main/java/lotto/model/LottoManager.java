package lotto.model;

import java.util.List;
import lotto.model.draw.BonusNumber;
import lotto.model.draw.WinningLottoTicket;
import lotto.model.draw.DrawResult;
import lotto.model.strategy.CustomStrategy;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.PurchaseAmount;
import lotto.model.strategy.RandomStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    private PurchaseAmount purchaseAmount;
    private LottoTicket lottoTicket;
    private DrawResult drawResult;

    public LottoManager(InputView inputView, OutputView outputView, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        buyLottoTicket();
        draw();
        displayDrawStatistics();
    }

    private void buyLottoTicket() {
        purchaseAmount = receivePurchaseAmount();
        List<Lotto> lottos = lottoGenerator.generateLottos(RandomStrategy.of(),purchaseAmount);
        lottoTicket = LottoTicket.of(lottos);
        outputView.printLottoTicket(lottoTicket, purchaseAmount.calculatePurchasableLottoAmount());
    }

    private void draw() {
        Lotto winningLotto = generateWinningLotto();
        BonusNumber bonusNumber = generateBonusNumber(winningLotto);
        WinningLottoTicket winningLottoTicket = generateWinningLottoTicket(winningLotto, bonusNumber);
        drawResult = DrawResult.of(winningLottoTicket, lottoTicket);
        drawResult.generateDrawResult();
    }

    private void displayDrawStatistics() {
        outputView.printDrawResult(drawResult);
        int totalPrizeMoney = drawResult.calculateTotalPrizeMoney();
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

    private Lotto generateWinningLotto() {
        while (true) {
            try {
                String inputNumbers = inputView.enterWinningNumbers();
                return lottoGenerator.generateSingleLotto(CustomStrategy.of(inputNumbers));
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    private BonusNumber generateBonusNumber(Lotto winningLotto) {
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

    private WinningLottoTicket generateWinningLottoTicket(Lotto winningLotto, BonusNumber bonusNumber) {
        return WinningLottoTicket.of(winningLotto, bonusNumber);
    }

}
