package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import lotto.domain.LottoRank;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoProfit;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.domain.QuickLottoGenerator;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.dto.LottoNumber;
import lotto.dto.WinningRecipe;
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
        responseLottos(lottos);
        final WinningNumbers winningNumbers = requestWinningNumbers();
        Console.close();
        responseResult(winningNumbers, lottos, money);
    }

    private void responseResult(final WinningNumbers winningNumbers, final List<Lotto> lottos, Money money) {
        final WinningResult winningResult = new WinningResult(winningNumbers, lottos);
        final LottoProfit lottoProfit = new LottoProfit(winningResult.getLottoRanks(), money);
        responseWinningResult(winningResult);
        responseLottoProfit(lottoProfit);
    }

    private void responseLottos(final List<Lotto> lottos) {
        outputView.printLottoNumber(convertToLottoNumbers(lottos));
    }

    private List<LottoNumber> convertToLottoNumbers(final List<Lotto> lottos) {
        return lottos.stream()
                .map(LottoNumber::of)
                .toList();
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
            outputView.printAskMoney();
            final int number = inputView.readNumber();
            return new Money(number);
        });
    }

    private WinningNumbers requestWinningNumbers() {
        final Lotto lotto = requestWinningNumber();
        return tryCatchLoopTemplate(() -> {
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
        return new LottoStore(new QuickLottoGenerator());
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
