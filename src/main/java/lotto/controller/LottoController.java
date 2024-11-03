package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.SystemMessage;

public class LottoController {
    private final LottoService lottoService;
    private final long numberOfLottery;
    private final List<Integer> winningLottery;
    public final int bonusLottery;

    public LottoController() {
        numberOfLottery = InputView.getInstance().enterPaymentForLottery();
        System.out.println(numberOfLottery + SystemMessage.NUMBER_OF_LOTTERY);
        lottoService = new LottoService(numberOfLottery);
        lottoService.getLotteries().forEach(System.out::println);

        winningLottery = InputView.getInstance().enterWinningLottery();
        bonusLottery = InputView.getInstance().enterBonusLottery();

    }

    public void start() {
        lottoService.start();
    }
}
