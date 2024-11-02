package lotto.utils;

import lotto.validator.BonusNumValidator;
import lotto.validator.MoneyValidator;
import lotto.validator.WinningNumValidator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }
    public int readMoney() {
        String moneyInput = inputView.readMoney();
        new MoneyValidator().validate(moneyInput);
        return Integer.parseInt(moneyInput);
    }

    public List<Integer> readWinningNum() {
        String winningNumInput = inputView.readLottoNum();
        new WinningNumValidator().validate(winningNumInput);
        return WinningNumSplit(winningNumInput);
    }

    public int readBonusNum(){
        String bonusNum = inputView.readBonusNum();
        new BonusNumValidator().validate(bonusNum);
        return Integer.parseInt(bonusNum);
    }

    private List<Integer> WinningNumSplit(String winningNumInput) {
        String[] winningNumSplit = winningNumInput.split(",");
        List<Integer> winningNums = new ArrayList<>();
        for (String winningNum : winningNumSplit) {
            winningNums.add(Integer.parseInt(winningNum));
        }
        return winningNums;
    }

}
