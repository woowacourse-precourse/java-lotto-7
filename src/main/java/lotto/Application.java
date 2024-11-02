package lotto;

import lotto.util.InputHandler;

public class Application {
    public static void main(String[] args) {
        Purchase purchase = InputHandler.repeatInputOrderPrice();
        Lotto lotto = InputHandler.repeatInputLottoNumber();
        Bonus bonus = InputHandler.repeatInputBonusNumber(lotto);
    }
}
