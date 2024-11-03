package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.extractor.LottoExtractor;
import lotto.io.InputHandler;
import lotto.io.PurchasePrintHandler;
import lotto.io.ResultPrintHandler;
import lotto.io.request.LottoRequest;
import lotto.io.request.NumberRequest;

public class LottoService {

    private final InputHandler inputHandler;
    private final PurchasePrintHandler purchaseHandler;
    private final ResultPrintHandler resultHandler;

    public LottoService() {
        this.inputHandler = new InputHandler();
        this.purchaseHandler = new PurchasePrintHandler();
        this.resultHandler = new ResultPrintHandler();
    }

    public void run() {
        Lottos lottos = getLottos();
        WinningLotto winningLotto = getWinningLotto();
        
    }

    private Lottos getLottos() {
        purchaseHandler.printPurchaseMessage();
        NumberRequest request = inputHandler.getBudgets();
        return createLottos(request);
    }

    private Lottos createLottos(NumberRequest request) {
        int budgets = Integer.parseInt(request.number());
        Lottos lottos = Lottos.from(budgets);
        purchaseHandler.printPurchaseAmounts(lottos.getAmounts());
        purchaseHandler.printPurchaseResult(lottos.getPurchaseLotto());
        return lottos;
    }

    private WinningLotto getWinningLotto() {
        Lotto lotto = getWinningNumber();
        int bonusNumber = getBonusNumber();
        return createWinningLotto(lotto, bonusNumber);
    }

    private Lotto getWinningNumber() {
        purchaseHandler.printWinningNumbers();
        LottoRequest lottoRequest = inputHandler.getWinningNumbers();
        LottoExtractor extractor = new LottoExtractor();
        List<Integer> numbers = extractor.extractLotto(lottoRequest.winningNumbers());
        return new Lotto(numbers);
    }

    private int getBonusNumber() {
        purchaseHandler.printBonusNumbers();
        NumberRequest numberRequest = inputHandler.getBonusNumber();
        return Integer.parseInt(numberRequest.number());
    }

    private WinningLotto createWinningLotto(Lotto lotto, int bonusNumber) {
        return WinningLotto.from(lotto, bonusNumber);
    }

}
