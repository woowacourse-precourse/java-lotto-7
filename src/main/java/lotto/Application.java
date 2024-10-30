package lotto;

import lotto.controller.LottoController;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {

        View view = new View();
        LottoController controller = new LottoController(view);

        controller.run();
    }
}
