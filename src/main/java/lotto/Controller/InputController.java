package lotto.Controller;

import static lotto.constants.Constants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.Lotto;
import lotto.View.InputView;

public class InputController {


    //복권 구매가격 받아오기
    public int getPurchasePrice() {
        return InputView.getPurchasePrice() / LOTTO_PRICE;
    }

    //복권 당첨숫자 받아오기
    public Lotto getWinningNumber() {
        return InputView.getWinningLottoNumber();
    }

    //복권의 보너스숫자 받아오기
    public int getBonusNumber() {
        return InputView.getBonusNumber();
    }


}
