package lotto.controller.manager;

import java.util.List;
import lotto.validator.InputValidator.BonusNumberValidator;
import lotto.validator.InputValidator.MoneyValidator;
import lotto.validator.InputValidator.WinningNumberValidator;
import lotto.view.View;

public class InputManager {

    private final View view;

    public InputManager(View view) {
        this.view = view;
    }

    public int getMoney() {
        MoneyValidator moneyValidator = new MoneyValidator();

        try {
            int money = moneyValidator.validate(view.getUserInput());// 금액 입력
            return money; // 유효한 금액이면 반환
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 재입력 요청
            return getMoney();
        }

    }


    public List<Integer> getWinningNumbers() {
        WinningNumberValidator winningNumberValidator = new WinningNumberValidator();

        try {
            List<Integer> winningNumbers = winningNumberValidator.validate(view.getWinningNumbers());// 금액 입력
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 재입력 요청
            return getWinningNumbers();
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

        try {
            int bonusNumber = bonusNumberValidator.validate(view.getBonusNumbers(), winningNumbers);// 금액 입력
            return bonusNumber; // 유효한 금액이면 반환
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 재입력 요청
            return getBonusNumber(winningNumbers);
        }
    }

}



