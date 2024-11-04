package lotto;
import lotto.controller.LottoController;
import lotto.services.LottoService;
import lotto.services.LottoServices;
import lotto.view.*;

public class Application {
    public static void main(String[] args) {
        LottoServices lottoServices = new LottoService();
        InputViewer inputViewer = new InputView();
        OutputViewer outputViewer = new OutputView();
        LottoController controller = new LottoController(lottoServices, inputViewer, outputViewer);

        controller.start();
    }
}
