package lotto.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGame;
import lotto.Domain.MoneyValidator;
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
        String purchaseAmount = inputView.readPurchaseAmount();
        MoneyValidator.validate(purchaseAmount);
        LottoGame game = new LottoGame(Integer.parseInt(purchaseAmount));

        printPurchasedLottos(game.getLottos());
        processWinningNumbers(game);
        printGameResults(game);
    }

    private void processWinningNumbers(LottoGame game) {
        List<Integer> winningNumbers = parseWinningNumbers(inputView.readWinningNumbers());
        int bonusNumber = Integer.parseInt(inputView.readBonusNumber());
        game.checkResult(new WinningLotto(winningNumbers, bonusNumber));
    }

    private List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void printPurchasedLottos(List<Lotto> lottos) {
        outputView.printPurchaseResult(lottos.size());
        lottos.forEach(lotto -> outputView.printLottoNumbers(lotto.getNumbers()));
    }

    private void printGameResults(LottoGame game) {
        outputView.printStatisticsTitle();
        printWinningStatistics(game);
        outputView.printProfitRate(game.calculateProfitRate());
    }

    private void printWinningStatistics(LottoGame game) {
        Arrays.stream(LottoPrizeRank.values())
                .filter(rank -> rank != LottoPrizeRank.MISS)
                .forEach(rank -> outputView.printMatchResult(
                        rank.resultMessage,
                        game.getWinningCount(rank)
                ));
    }
}