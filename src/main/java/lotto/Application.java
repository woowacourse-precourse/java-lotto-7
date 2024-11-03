package lotto;

import lotto.manager.GameController;
import lotto.util.function.LottoNumberSupplier;
import lotto.util.function.LottoNumberSupplierImpl;

public class Application {

    public static void main(String[] args) {

        LottoNumberSupplier lottoNumberSupplier = new LottoNumberSupplierImpl();
        GameController gameController = new GameController(lottoNumberSupplier);

        gameController.run();
    }
}
