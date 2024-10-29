package lotto.lottoController;

import lotto.lottoModel.LotteryDAO;
import lotto.lottoModel.LotteryDTO;
import lotto.lottoModel.Lotto;
import lotto.lottoView.InputView;
import lotto.lottoView.OutputView;

public class LottoController {
    private LotteryDAO lotteryDAO;
    private LotteryDTO lotteryDTO;
    private InputView inputView;
    private OutputView outputView;

    public LottoController() {
        this.lotteryDAO = new LotteryDAO();
        this.lotteryDTO = new LotteryDTO();
        this.inputView = new InputView();
        this.outputView = new OutputView();

    }

    public void run() {

    }


}
