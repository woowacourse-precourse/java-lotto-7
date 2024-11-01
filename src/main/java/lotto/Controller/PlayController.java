package lotto.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Model.EarningRate;
import lotto.Model.LottoNumbers;
import lotto.Model.PlayLottoGame;
import lotto.Model.Ranking;
import lotto.View.OutputView;

public class PlayController {
    private final InputController inputController;
    private final OutputView outputView;
    private int gameNumber;
    private ArrayList<Integer> winningNumbers;
    private List<Lotto> lottoNumberList;
    private PlayLottoGame playLottoGame;
    private Map<Integer, Boolean> matchingNumber;
    private Map<Ranking, Integer> resultSet;

    public PlayController() {
        inputController = new InputController();
        outputView = new OutputView();
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
        resultSet = new HashMap<>();
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
        outputView.printSuccessResult();
        outputView.printResult(resultSet);
        outputView.printRevenueRate(EarningRate.returnEarningRate(gameNumber, resultSet));
    }
}
