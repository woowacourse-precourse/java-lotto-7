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
        boolean flag = true;
        MoneyValidator moneyValidator = new MoneyValidator();
        String moneyInput = null;
        while (flag) {
            try {
                moneyInput = inputView.readMoney();
                moneyValidator.validate(moneyInput);
                flag=false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return Integer.parseInt(moneyInput);
    }

    public List<Integer> readWinningNum() {

        boolean flag = true;
        WinningNumValidator winningNumValidator = new WinningNumValidator();
        String lottoNumInput = null;
        while (flag) {
            try {
                lottoNumInput = inputView.readLottoNum();
                winningNumValidator.validate(lottoNumInput);
                flag=false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return lottoNumSplit(lottoNumInput);
    }

    public int readBonusNum(){        boolean flag = true;
        BonusNumValidator bonusNumValidator = new BonusNumValidator();
        String bonusInput = null;
        while (flag) {
            try {
                bonusInput = inputView.readMoney();
                bonusNumValidator.validate(bonusInput);
                flag=false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return Integer.parseInt(bonusInput);
    }

    private List<Integer> lottoNumSplit(String winningNumInput) {
        String[] winningNumSplit = winningNumInput.split(",");
        List<Integer> winningNums = new ArrayList<>();
        for (String winningNum : winningNumSplit) {
            winningNums.add(Integer.parseInt(winningNum));
        }
        return winningNums;
    }

}
