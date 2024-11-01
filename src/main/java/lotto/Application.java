package lotto;
import lotto.controller.LottoController;
import lotto.services.LottoService;
import lotto.services.LottoServices;
import lotto.view.ErrorView;

public class Application {
    public static void main(String[] args) {
        ErrorView lottoView = new ErrorView();
        LottoServices lottoServices = new LottoService();
        LottoController controller = new LottoController(lottoView, lottoServices);
        controller.start();
    }
}
