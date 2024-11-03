package lotto.Controller;

import static lotto.constants.Constants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.View.InputView;

public class InputController {

    private final InputView inputView = new InputView();

    //복권 구매가격 받아오기
    public int getPurchasePrice() {
        return inputView.getPurchasePrice() / LOTTO_PRICE;
    }

    //복권 당첨숫자 받아오기
    public ArrayList<Integer> getWinningNumber() {
        String[] winningNumber = inputView.getWinningNumber();
        return new ArrayList<>(Arrays.stream(winningNumber)
                .map(Integer::valueOf)
                .toList());
    }

    //복권의 보너스숫자 받아오기
    public int getBonusNumber() {
        return inputView.getBonusNumber();
    }


}
