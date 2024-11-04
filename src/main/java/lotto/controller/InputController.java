package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.Constant;
import lotto.view.InputView;

public class InputController {

    public int setPurchasePrice() {
        while (true) {
            try {
                String inputPurchasePrice = InputView.inputPurchasePrice();
                return Integer.parseInt(inputPurchasePrice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> setWinningNumbers() {
        while (true) {
            try{
                String inputLottoNumbers = InputView.inputWinningNumbers();
                return splitNumbers(inputLottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> splitNumbers(String winningNumbers) {
        String[] tokenNumbers = winningNumbers.split(Constant.COMMA_SEPARATOR);
        List<Integer> resultNumbers = new ArrayList<>();
        for (String token : tokenNumbers) {
            resultNumbers.add(Integer.parseInt(token));
        }
        return resultNumbers;
    }

    public int setBonusNumber() {
        while (true) {
            try {
                String inputBonusNumber = InputView.inputBonusNumber();
                return Integer.parseInt(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
