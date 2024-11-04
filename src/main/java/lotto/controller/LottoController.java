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
        int amount = getPurchaseAmount();
        List<Lotto> lottos = createLottos(amount);

        outputView.printPurchaseCount(lottos.size());
        outputView.printLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        outputView.printResult(lottoResult);
    }

    private int getPurchaseAmount() {
        outputView.printPurchaseAmountMessage();
        try {
            return inputView.readPurchaseAmount();
        } catch (IllegalArgumentException e) { // 실패할 경우 에러메세지 출력 후 다시 입력받음
            outputView.printErrorMessage(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private WinningLotto getWinningLotto() {
        Lotto lotto = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        try {
            return new WinningLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) { // 실패할 경우 에러메세지 출력 후 다시 입력받음
            outputView.printErrorMessage(e.getMessage());
            return getWinningLotto();
        }
    }

    private Lotto getWinningNumbers() {
        outputView.printWinningNumbersMessage();
        try {
            List<Integer> numbers = inputView.readWinningNumbers();
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) { // 실패할 경우 에러메세지 출력 후 다시 입력받음
            outputView.printErrorMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    private int getBonusNumber() {
        outputView.printBonusNumberMessage();
        try {
            return inputView.readBonusNumber();
        } catch (IllegalArgumentException e) { // 실패할 경우 에러메세지 출력 후 다시 입력받음
            outputView.printErrorMessage(e.getMessage());
            return getBonusNumber();
        }
    }

    private List<Lotto> createLottos(int amount) {
        int count = amount / LottoConstant.LOTTO_PURCHASE_AMOUNT.getIntValue();
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .toList();
    }
}
