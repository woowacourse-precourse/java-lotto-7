package lotto.Controller;

import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGame;
import lotto.Domain.LottoMachine;
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
        int purchaseAmount = inputView.readPurchaseAmount();
        LottoGame game = createGame(purchaseAmount);

        printPurchasedLottos(game);

        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();

        game.start(winningNumbers, bonusNumber);
        game.drawLottery();

        printGameResults(game);
    }

    private LottoGame createGame(int amount) {
        List<Lotto> lottos = LottoMachine.issue(amount);
        outputView.printPurchaseResult(lottos.size());
        return new LottoGame(amount, lottos);
    }

    private void printPurchasedLottos(LottoGame game) {
        for (Lotto lotto : game.getPurchasedLottos()) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }

    private void printGameResults(LottoGame game) {
        outputView.printStatisticsTitle();
        for (LottoPrizeRank rank : LottoPrizeRank.values()) {
            outputView.printMatchResult(rank.resultMessage, game.getWinningCount(rank));
        }
        outputView.printProfitRate(game.getProfitRate());
    }
}
}
