package lotto.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGame;
import lotto.Domain.WinningLotto;
import lotto.Enum.LottoPrizeRank;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        final int money = Integer.parseInt(inputView.readPurchaseAmount());
        final LottoGame game = new LottoGame(money);

        printPurchasedLottos(game.getLottos());

        final String[] winningInput = inputView.readWinningNumbers().split(",");
        final List<Integer> winningNumbers = Arrays.stream(winningInput)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        final int bonusNumber = Integer.parseInt(inputView.readBonusNumber());

        game.checkResult(new WinningLotto(winningNumbers, bonusNumber));
        printGameResults(game);
    }

    private void printPurchasedLottos(List<Lotto> lottos) {
        outputView.printPurchaseResult(lottos.size());
        lottos.forEach(lotto -> outputView.printLottoNumbers(lotto.getNumbers()));
    }

    private void printGameResults(LottoGame game) {
        outputView.printStatisticsTitle();
        Arrays.stream(LottoPrizeRank.values())
                .forEach(rank -> outputView.printMatchResult(
                        rank.resultMessage,
                        game.getWinningCount(rank)
                ));
        outputView.printProfitRate(game.calculateProfitRate());
    }
}