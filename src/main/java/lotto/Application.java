package lotto;

import java.util.List;
import lotto.controller.FirstRankLottoController;
import lotto.controller.LottoController;
import lotto.model.FirstRankLotto;
import lotto.model.Lotto;

public class Application {

    private final LottoController lottoController;
    private final FirstRankLottoController firstRankLottoController;

    public Application() {
        this.lottoController = new LottoController();
        this.firstRankLottoController = new FirstRankLottoController();
    }

    public static void main(String[] args) {
        Application application = new Application();

        application.run();
    }

    private void run() {
        List<Lotto> lottos = lottoController.buyLotto();
        FirstRankLotto firstRankLotto = firstRankLottoController.generateFirstRankLotto();

        lottoController.announceStatistics(lottos, firstRankLotto);
    }
}
