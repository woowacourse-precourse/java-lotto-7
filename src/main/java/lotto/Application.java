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
        LottoService game = new LottoService();
        LottoServices lottoServices = new LottoService();
        LottoStatistics statistics = new LottoStatistic();
        LottoController controller = new LottoController(lottoView, lottoServices, statistics);
        controller.start();
    }
}
