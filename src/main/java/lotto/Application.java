package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        try {
            int money = InputView.inputMoney();
            ArrayList<Lotto> lottos = LottoManager.createLottos(money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
