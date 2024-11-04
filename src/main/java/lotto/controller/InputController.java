package lotto.controller;

import lotto.IO.InputHandler;
import lotto.constants.ErrorMessage;

import java.util.List;

public abstract class InputController {

    public static int getPrice() {
        while (true) {
            try {
                return InputHandler.getPrice();
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.PRICE_NOT_NUMBER.getMessage());
            }
        }
    }

    public static List<Integer> getWinningLottoNumber() {
        while (true) {
            try {
                return InputHandler.getWinningLottoNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.WINNING_NUMBER_DUPLICATION.getMessage());
            }
        }
    }

    public static int getBonusNumber(List<Integer> winningNumber) {
        while (true) {
            try {
                return InputHandler.getBonusNumber(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.BONUS_NUMBER_DUPLICATION.getMessage());
            }
        }
    }
}
