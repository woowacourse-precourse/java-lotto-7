package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lotto.Lotto;
import lotto.Model.Service.EarningRate;
import lotto.Model.Service.LottoNumbers;
import lotto.Model.Service.PlayLottoGame;
import lotto.Model.Ranking;
import lotto.View.OutputView;

public class PlayController {
    private final int gameNumber;
    private final ArrayList<Integer> winningNumbers;
    private final List<Lotto> lottoNumberList;
    private final PlayLottoGame playLottoGame;
    private final InputController inputController;
    private Map<Integer, Boolean> gameResult;
    private Map<Ranking, Integer> totalResultSet;

    public PlayController() {
        this.inputController = new InputController();
        gameNumber = inputController.getPurchasePrice();
        lottoNumberList = LottoNumbers.makeLottoList(gameNumber);
        winningNumbers = inputController.getWinningNumber();
        int bonusNumber = inputController.getBonusNumber();
        playLottoGame = new PlayLottoGame(winningNumbers, lottoNumberList, bonusNumber);
        initializeResultSet();
    }

    public void play() {
        gameResult = playLottoGame.play();
        updateResultSet();
    }

    private void initializeResultSet() {
        totalResultSet = new TreeMap<>();
        for (Ranking rank : Ranking.values()) {
            totalResultSet.put(rank, 0);
        }
    }

    private void updateResultSet() {
        gameResult.forEach((count, bonus) -> {
            Ranking rank = Ranking.valueOf(count, bonus);
            totalResultSet.put(rank, totalResultSet.get(rank) + 1);
        });
    }

    public void showResult() {
        OutputView.printWinningStatistics();
        OutputView.printResult(totalResultSet);
        OutputView.printRevenueRate(EarningRate.returnEarningRate(gameNumber, totalResultSet));
    }
}
