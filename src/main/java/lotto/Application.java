package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Lotto> lottos = new ArrayList<>();
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
        lottos = lottoVendingMachine.purchaseLottos();

        Drow drow = new Drow();
        drow.inputDrowNumbers();
        drow.inputBonusNumber();


    }
}
