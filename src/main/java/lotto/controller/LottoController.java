package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.util.LottoConstant;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoNumberGenerator = new LottoNumberGenerator();
    }

    public void run() {
        outputView.printPurchaseAmountMessage();
        int amount = inputView.readPurchaseAmount();

        List<Lotto> lottos = createLottos(amount);
        outputView.printPurchaseCount(lottos.size());
        outputView.printLottos(lottos);

        WinningLotto winningLotto = createWinningLotto();
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        outputView.printResult(lottoResult);
    }

    private List<Lotto> createLottos(int amount) {
        int count = amount / LottoConstant.LOTTO_PURCHASE_AMOUNT.getIntValue();

        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .toList();
    }

    private WinningLotto createWinningLotto() {
        outputView.printWinningNumbersMessage();
        List<Integer> winningNumbers = inputView.readWinningNumbers();

        outputView.printBonusNumberMessage();
        int bonusNumber = inputView.readBonusNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
