package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import lotto.domain.winning.LottoRank;
import lotto.domain.number.Bonus;
import lotto.domain.number.Lotto;
import lotto.domain.winning.LottoProfit;
import lotto.domain.purchase.LottoStore;
import lotto.domain.purchase.Money;
import lotto.domain.generator.QuickLottoGenerator;
import lotto.domain.number.Winning;
import lotto.domain.winning.WinningResult;
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
        final Winning winning = requestWinningNumbers();
        Console.close();
        responseResult(winning, lottos, money);
    }

    private void responseResult(final Winning winning, final List<Lotto> lottos, Money money) {
        final WinningResult winningResult = new WinningResult(winning, lottos);
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

    private Winning requestWinningNumbers() {
        final Lotto lotto = requestWinningNumber();
        return tryCatchLoopTemplate(() -> {
            final Bonus bonus = requestBonusNumber();
            return new Winning(lotto, bonus);
        });
    }

    private Bonus requestBonusNumber() {
        return tryCatchLoopTemplate(() -> {
            outputView.printAskBonusNumber();
            final int number = inputView.readNumber();
            return new Bonus(number);
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
