package lotto;
import lotto.controller.LottoController;
import lotto.model.LottoStatistic;
import lotto.model.LottoStatistics;
import lotto.services.LottoService;
import lotto.services.LottoServices;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoView lottoView = new LottoView();
        LottoServices lottoServices = new LottoService();
        LottoController controller = new LottoController(lottoView, lottoServices);
        controller.start();
    }
}
