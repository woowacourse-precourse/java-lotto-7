package lotto.Controller;

import lotto.Model.LottoAmount;

public class LottoController {
    private LottoAmount amountOfLotto;

    public LottoController(){
        set();
        makeLottos();
    }
    private void set(){
        amountOfLotto = InputController.setAmountOfLotto();
    }
    private void makeLottos(){

    }
}