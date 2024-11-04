package lotto;

import lotto.Controller.LottoController;
import lotto.Service.EarningRateService;
import lotto.Service.IssueMyLottoService;
import lotto.Service.WinningTotalService;
import lotto.View.InputLottoView;
import lotto.View.OutputEarningRateView;
import lotto.View.OutputMyLottosView;
import lotto.View.OutputWinningTotalView;

public class Application {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        LottoController lottoController = new LottoController(
                new IssueMyLottoService(),
                new WinningTotalService(),
                new EarningRateService(),
                new OutputWinningTotalView(),
                new InputLottoView(),
                new OutputMyLottosView(),
                new OutputEarningRateView());

        lottoController.startLottery();
    }
}
