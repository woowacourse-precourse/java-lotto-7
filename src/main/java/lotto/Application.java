package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoView view = new LottoView();
        LottoService service = new LottoService();

        LottoController controller = new LottoController(view, service);

        controller.run();
    }
}
