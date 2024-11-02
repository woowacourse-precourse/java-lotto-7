package lotto;

import lotto.Controller.LottoController;
import lotto.Service.EarningRateService;
import lotto.Service.IssueTicketService;
import lotto.Service.WinningTotalService;
import lotto.View.InputLottoView;
import lotto.View.OutputEarningRateView;
import lotto.View.OutputIssuedTicketView;
import lotto.View.OutputWinningTotalView;

public class Application {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        LottoController lottoController = new LottoController(
                new IssueTicketService(),
                new WinningTotalService(),
                new EarningRateService(),
                new OutputWinningTotalView(),
                new InputLottoView(),
                new OutputIssuedTicketView(),
                new OutputEarningRateView());

        lottoController.startLottery();
    }
}
