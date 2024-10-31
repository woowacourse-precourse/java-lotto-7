package lotto.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.View.InputView;

public class InputController {

    private InputView inputView;

    public int setPurchasePrice() {
        return inputView.inputPurchasePrice() / 1000;
    }

    public ArrayList<Integer> setWinningNumber() {
        String[] winningNumber = inputView.setWinningNumber();
        return new ArrayList<>(Arrays.stream(winningNumber)
                .map(Integer::valueOf)
                .toList());
    }

    public int setBonusNumber() {
        return inputView.setBonusNumber();
    }


}
