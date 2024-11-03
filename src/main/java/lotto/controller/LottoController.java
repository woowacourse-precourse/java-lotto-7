package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final LottoService lottoService;
    private final long numberOfLottery;
    private final List<Integer> winningLottery;
    public final int bonusLottery;

    public LottoController() {
        numberOfLottery = InputView.getInstance().enterPaymentForLottery();
        winningLottery = InputView.getInstance().enterWinningLottery();
        bonusLottery = InputView.getInstance().enterBonusLottery();

        lottoService = new LottoService(numberOfLottery);
    }

    public void start() {
        lottoService.start();
    }
}
