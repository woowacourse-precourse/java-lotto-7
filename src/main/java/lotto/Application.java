package lotto;
import lotto.controller.LottoController;
import lotto.services.LottoService;
import lotto.services.LottoServices;
import lotto.view.ErrorView;

public class Application {
    public static void main(String[] args) {
        LottoServices lottoServices = new LottoService();
        LottoController controller = new LottoController(lottoServices);
        controller.start();
    }
}
