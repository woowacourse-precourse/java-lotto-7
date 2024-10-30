package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Model.LottoNumbers;

public class PlayController {
    private final InputController inputController;
    private  int gameNumber;


    public PlayController() {
        inputController = new InputController();
    }

    public void set() {
        gameNumber = setGameNumber();
        ArrayList<Integer> winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber();
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





}
