package lotto.controller;

import java.util.List;
import lotto.domain.*;
import lotto.input.*;
import lotto.service.LottoService;
import lotto.view.*;

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
        int purchaseCount= setPurchaseCount();
        outputView.printLottoCount(purchaseCount);
        Lottos lottos = lottoService.generateLottos(purchaseCount);
        outputView.printLottoNumbers(lottos);
        Lotto winningLotto = setWinLotto();
        int bonusNumber = setBonusNumber(winningLotto);
    }

    private int setPurchaseCount() {
        String purchaseAmount = inputView.getPurchaseAmount();
        return PurchaseAmountProcessor.calculatePurchaseCount(purchaseAmount);
    }

    private Lotto setWinLotto() {
        String winNumbers = inputView.getWinningNumber();
        List<Integer> winningNumbers = WinningNumberProcessor.processWinningNumbers(winNumbers);
        return new Lotto(winningNumbers);
    }

    private int setBonusNumber(Lotto winLotto) {
        String bonusNumber = inputView.getBonusNumber();
        return BonusNumberProcessor.validateAndParse(winLotto.getNumbers(), bonusNumber);
    }


}
