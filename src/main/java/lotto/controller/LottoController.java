package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.common.Winning;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final LottoService lottoService;

    private final InputView inputView;

    public LottoController() {
        lottoService = new LottoService();

        this.inputView = new InputView();
    }

    public void run() {
        String inputPayment = inputView.readPayment();
        int payment = Integer.parseInt(inputPayment);
        int payCount = payment / 1000;

        List<Lotto> lottos = lottoService.initLotto(payCount);

        String inputWinningNumbers = inputView.readWinningNumbers();
        String[] rawWinningNumbers = inputWinningNumbers.split(",");
        List<Integer> winningNumbers = Arrays.stream(rawWinningNumbers).map(Integer::parseInt).toList();

        String inputBonus = inputView.readBonus();
        int bonus = Integer.parseInt(inputBonus);

        Map<Winning, Integer> winnings = lottoService.getWinnings(lottos, winningNumbers, bonus);
        double yield = lottoService.getYield(payment, winnings);
    }
}
