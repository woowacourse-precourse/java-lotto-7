package lotto.Controller;

import lotto.View.InputLottoView;


public class LottoController {
    static final InputLottoView inputLottoView = new InputLottoView();


    public void init() {
        int price = inputLottoView.inputPrice();
    }
}
