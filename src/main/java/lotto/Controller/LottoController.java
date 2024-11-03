package lotto.Controller;

import java.util.List;
import lotto.Input.InputProcessor;
import lotto.Input.InputView;
import lotto.Output.OutputView;
import lotto.Service.LottoService;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.WinningNumbers;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = purchaseLottos();
        List<Lotto> lottos = generateLottos(purchaseAmount);
        outputView.printLottos(lottos);

        WinningNumbers winningNumbers = createWinningNumbers();
        LottoResult result = lottoService.createWinningResult(lottos, winningNumbers);
        outputView.printWinningStatistics(result);
    }

    private List<Lotto> generateLottos(PurchaseAmount purchaseAmount) {
        return lottoService.generateLottos(purchaseAmount.getAmount());
    }

    private PurchaseAmount purchaseLottos() {
        return new InputProcessor<PurchaseAmount>(outputView) {
            @Override
            protected PurchaseAmount processInput() {
                String input = inputView.readPurchaseAmount();
                return PurchaseAmount.from(input);
            }
        }.process();
    }

    private WinningNumbers createWinningNumbers() {
        WinningLottoNumbers winningNumbers = createWinningLottoNumbers();
        BonusNumber bonusNumber = createBonusNumber();
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private WinningLottoNumbers createWinningLottoNumbers() {
        return new InputProcessor<WinningLottoNumbers>(outputView) {
            @Override
            protected WinningLottoNumbers processInput() {
                String input = inputView.readWinningNumbers();
                return WinningLottoNumbers.from(input);
            }
        }.process();
    }

    private BonusNumber createBonusNumber() {
        return new InputProcessor<BonusNumber>(outputView) {
            @Override
            protected BonusNumber processInput() {
                String input = inputView.readBonusNumber();
                return BonusNumber.from(input);
            }
        }.process();
    }
}