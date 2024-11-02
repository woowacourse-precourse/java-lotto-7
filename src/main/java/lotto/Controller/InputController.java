package lotto.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.View.InputView;

public class InputController {

    private final InputView inputView = new InputView();
    private static final int LOTTO_PRICE = 1000;

    //복권 구매가격 받아오기
    public int setPurchasePrice() {
        return inputView.setPurchasePrice()/LOTTO_PRICE;
    }
    //복권 당첨숫자 받아오기
    public ArrayList<Integer> setWinningNumber() {
        String[] winningNumber = inputView.setWinningNumber();
        return new ArrayList<>(Arrays.stream(winningNumber)
                .map(Integer::valueOf)
                .toList());
    }
    //복권의 보너스숫자 받아오기
    public int setBonusNumber() {
        return inputView.setBonusNumber();
    }


}
