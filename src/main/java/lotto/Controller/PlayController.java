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
    static int gameNumber;
    ArrayList<Integer> winningNumbers;
    List<Lotto> lottoNumberList;
    PlayLottoGame playLottoGame;
    Map<Integer,Boolean> matchingNumber;
    static Map<Ranking,Integer> resultSet;
    OutputView outputView;


    public PlayController() {
        inputController = new InputController();
        gameNumber = setGameNumber();
        lottoNumberList = LottoNumbers.makeLottoList(gameNumber);
        winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber();
        playLottoGame = new PlayLottoGame(winningNumbers, lottoNumberList,bonusNumber);
        resultSet = new HashMap<>();
    }


    public int setGameNumber() {
        return inputController.setPurchasePrice();
    }

    public ArrayList<Integer> setWinningNumbers() {
        return inputController.setWinningNumber();
    }

    public int setBonusNumber() {
        return inputController.setBonusNumber();
    }

    public void play(){
        matchingNumber=playLottoGame.play();
    }

    public void setResult(){
        initializeResultSet();
        matchingNumber.forEach((count,bonus) -> {
            Ranking rank = Ranking.valueOf(count,bonus);

            resultSet.put(rank,resultSet.get(rank)+1);
        });
    }

    private void initializeResultSet() {
        for (Ranking rank : Ranking.values()) {
            resultSet.put(rank, 0);
        }
    }

    public void showResult(){
        outputView=new OutputView(resultSet);
        outputView.printSuccessResult();
        outputView.printresult();
        OutputView.PrintRevenueRate(EarningRate.returnEarningRate(gameNumber,resultSet));
    }





}
