package lotto;

import java.lang.ModuleLayer.Controller;
import lotto.lottoController.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.run();
    }
}
