package lotto;

import lotto.manager.GameManager;
import lotto.util.LottoNumberSupplier;
import lotto.util.LottoNumberSupplierImpl;

public class Application {

    public static void main(String[] args) {

        LottoNumberSupplier lottoNumberSupplier = new LottoNumberSupplierImpl();
        GameManager gameManager = new GameManager(lottoNumberSupplier);

        gameManager.run();
    }
}
