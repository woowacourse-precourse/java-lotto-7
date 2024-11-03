package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lotto.Lotto;
import lotto.Model.EarningRate;
import lotto.Model.LottoNumbers;
import lotto.Model.PlayLottoGame;
import lotto.Model.Ranking;
import lotto.View.OutputView;

public class PlayController {
    private final int gameNumber;
    private final ArrayList<Integer> winningNumbers;
    private final List<Lotto> lottoNumberList;
    private final PlayLottoGame playLottoGame;
    private final InputController inputController;
    private Map<Integer, Boolean> matchingNumber;
    private Map<Ranking, Integer> resultSet;

    public PlayController() {
        this.inputController = new InputController();
        gameNumber = inputController.setPurchasePrice();
        lottoNumberList = LottoNumbers.makeLottoList(gameNumber);
        winningNumbers = inputController.setWinningNumber();
        int bonusNumber = inputController.setBonusNumber();
        playLottoGame = new PlayLottoGame(winningNumbers, lottoNumberList, bonusNumber);
        initializeResultSet();
    }

    public void play() {
        matchingNumber = playLottoGame.play();
        updateResultSet();
    }

    private void initializeResultSet() {
        resultSet = new TreeMap<>();
        for (Ranking rank : Ranking.values()) {
            resultSet.put(rank, 0);
        }
    }

    private void updateResultSet() {
        matchingNumber.forEach((count, bonus) -> {
            Ranking rank = Ranking.valueOf(count, bonus);
            resultSet.put(rank, resultSet.get(rank) + 1);
        });
    }

    public void showResult() {
        OutputView.printWinningStatistics();
        OutputView.printResult(resultSet);
        OutputView.printRevenueRate(EarningRate.returnEarningRate(gameNumber, resultSet));
    }
}
