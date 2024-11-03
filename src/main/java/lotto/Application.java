package lotto;

import lotto.controller.LottoController;
import lotto.controller.woowahanLotto;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new woowahanLotto();
        controller.run();
    }
}
