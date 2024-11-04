package lotto.controller;

import java.util.List;
import lotto.view.Input.InputProcessor;
import lotto.view.Input.InputView;
import lotto.view.Output.OutputView;
import lotto.service.LottoService;
import lotto.domain.number.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.result.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.number.WinningLottoNumbers;
import lotto.domain.number.WinningNumbers;

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
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);
        outputView.printLottos(lottos);

        WinningNumbers winningNumbers = processWinningNumbers();
        LottoResult result = lottoService.createWinningResult(lottos, winningNumbers, purchaseAmount);
        outputView.printWinningStatistics(result);
    }

    private WinningNumbers processWinningNumbers() {
        WinningLottoNumbers winningNumbers = createWinningLottoNumbers();
        BonusNumber bonusNumber = createBonusNumber();
        return lottoService.createWinningNumbers(winningNumbers, bonusNumber);
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
