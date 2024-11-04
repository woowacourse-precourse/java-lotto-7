package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.model.LottoBudget;
import lotto.model.LottoPrizes;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoBudget lottoBudget = retryUntilValid(this::readLottoBudget);

        String lottoCount = lottoBudget.getLottoCount();
        outputView.printLottoCount(lottoCount);

        Lottos lottos = generateLottos(lottoCount);

        List<String> lottoNumbers = lottos.getLottoNumbers();
        outputView.printLottoNumbers(lottoNumbers);

        String WinningNumbersInput = inputView.readWinningNumbers();
        Lotto mainNumbers = retryUntilValid(() -> Lotto.of(WinningNumbersInput));
        String bonusNumber = inputView.readBonusNumber();
        WinningNumbers winningNumbers = retryUntilValid(() -> new WinningNumbers(mainNumbers, bonusNumber));

        LottoPrizes lottoPrizes = new LottoPrizes(lottos, winningNumbers);

        List<String> matchStatistics = lottoPrizes.calculateMatchStatistics();
        outputView.printMatchStatistics(matchStatistics);

        String yield = lottoPrizes.calculateYield(lottoBudget.getValue());
        outputView.printYield(yield);
    }

    private static Lottos generateLottos(String lottoCount) {
        int lottoCountNumber = Integer.parseInt(lottoCount);
        Lottos lottos = Lottos.fromCount(lottoCountNumber);
        return lottos;
    }

    private LottoBudget readLottoBudget() {
        String lottoBudgetInput = inputView.readLottoBudget();
        return new LottoBudget(lottoBudgetInput);
    }

    private <T> T retryUntilValid(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
