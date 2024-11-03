package lotto.controller.manager;

import java.util.List;
import lotto.validator.BonusNumberValidator;
import lotto.validator.MoneyValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.View;

public class InputManager {

    private final View view;

    public InputManager(View view) {
        this.view = view;
    }

    public int getMoney() {
        MoneyValidator moneyValidator = new MoneyValidator();
        while (true) {
            try {
                int money = moneyValidator.validate(view.getUserInput());// 금액 입력
                return money; // 유효한 금액이면 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 재입력 요청
            }
        }
    }


    public List<Integer> getWinningNumbers() {
        WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
        while (true) {
            try {
                List<Integer> winningNumbers = winningNumberValidator.validate(view.getWinningNumbers());// 금액 입력
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 재입력 요청
            }
        }
    }

    public int getBonusNumber() {
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        while (true) {
            try {
                int bonusNumber = bonusNumberValidator.validate(view.getBonusNumbers());// 금액 입력
                return bonusNumber; // 유효한 금액이면 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 재입력 요청
            }
        }
    }

}



