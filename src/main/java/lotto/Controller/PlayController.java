package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Model.LottoNumbers;
import lotto.Model.PlayLottoGame;
import lotto.Model.Ranking;

public class PlayController {
    private final InputController inputController;
    private int gameNumber;
    private int bonusNumber;
    ArrayList<Integer> winningNumbers;
    List<Lotto> lottoNumberList;
    PlayLottoGame playLottoGame;
    Map<Integer,Boolean> matchingNumber;
    Map<Ranking,Integer> resultSet;


    public PlayController() {
        inputController = new InputController();
    }

    public void set() {
        gameNumber = setGameNumber();
        bonusNumber = setBonusNumber();
        winningNumbers = setWinningNumbers();
        lottoNumberList = LottoNumbers.makeLottoList(gameNumber);
        playLottoGame = new PlayLottoGame(winningNumbers, lottoNumberList,bonusNumber);
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

    public void showResult(){
        matchingNumber.forEach((count,bonus) -> {
            Ranking rank = Ranking.valueOf(count,bonus);

            resultSet.put(rank,resultSet.getOrDefault(rank,0)+1);
        });

    }





}
