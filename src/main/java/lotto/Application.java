package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoModel;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoView view = new LottoView();
        LottoModel model = new LottoModel();
        LottoController controller = new LottoController(view, model);

        controller.run();
    }
}
