package lotto.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.Model.Validation;
import lotto.View.InputView;

public class InputController {

    private final InputView inputView = new InputView();
    private final Validation validation = new Validation();
    private static final int LOTTO_PRICE = 1000;

    public int setPurchasePrice() {
        int purchasePrice = inputView.inputPurchasePrice();
        validation.purchaseValidator(purchasePrice);
        return purchasePrice/LOTTO_PRICE;
    }

    public ArrayList<Integer> setWinningNumber() {
        String[] winningNumber = inputView.setWinningNumber();
        validation.winningNumberValidator(winningNumber);

        return new ArrayList<>(Arrays.stream(winningNumber)
                .map(Integer::valueOf)
                .toList());
    }

    public int setBonusNumber() {
        int bonusNumber = inputView.setBonusNumber();
        validation.bonusNumberValidator(bonusNumber);  // 보너스 번호 추가 검증
        return bonusNumber;
    }


}
