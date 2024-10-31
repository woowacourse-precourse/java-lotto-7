package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import lotto.BonusNumber;
import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.LottoProfit;
import lotto.LottoRank;
import lotto.LottoStore;
import lotto.Money;
import lotto.WinningNumbers;
import lotto.WinningRecipe;
import lotto.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final LottoStore lottoStore = createLottoStore();
        final Money money = requestMoney();
        final List<Lotto> lottos = lottoStore.getLottosByMoney(money);
        final WinningNumbers winningNumbers = requestWinningNumbers();
        final WinningResult winningResult = new WinningResult(winningNumbers, lottos);
        final LottoProfit lottoProfit = new LottoProfit(winningResult.getLottoRanks(), money);
        responseResult(winningResult, lottoProfit);
    }

    private void responseResult(final WinningResult winningResult, final LottoProfit lottoProfit) {
        responseWinningResult(winningResult);
        responseLottoProfit(lottoProfit);
    }

    private void responseLottoProfit(final LottoProfit lottoProfit) {
        outputView.printProfitResult(lottoProfit.getProfitRatio());
    }

    private void responseWinningResult(final WinningResult winningResult) {
        outputView.printWinningResultTitle();
        final Map<LottoRank, Integer> lottoRanks = winningResult.getLottoRanks();
        outputView.printWinningResult(convertToWinningRecipes(lottoRanks));
    }

    private List<WinningRecipe> convertToWinningRecipes(final Map<LottoRank, Integer> lottoRanks) {
        return lottoRanks.entrySet().stream()
                .map(WinningRecipe::of)
                .toList();
    }


    private Money requestMoney() {
        return tryCatchLoopTemplate(() -> {
            final int number = inputView.readNumber();
            return new Money(number);
        });
    }

    private WinningNumbers requestWinningNumbers() {
        return tryCatchLoopTemplate(() -> {
            final Lotto lotto = requestWinningNumber();
            final BonusNumber bonusNumber = requestBonusNumber();
            return new WinningNumbers(lotto, bonusNumber);
        });
    }

    private BonusNumber requestBonusNumber() {
        return tryCatchLoopTemplate(() -> {
            outputView.printAskBonusNumber();
            final int number = inputView.readNumber();
            return new BonusNumber(number);
        });
    }

    private Lotto requestWinningNumber() {
        return tryCatchLoopTemplate(() -> {
            outputView.printAskWinningNumber();
            final List<Integer> numbers = inputView.readNumbers();
            return new Lotto(numbers);
        });
    }

    private LottoStore createLottoStore() {
        return new LottoStore(new LottoGenerator());
    }


    private <T> T tryCatchLoopTemplate(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
