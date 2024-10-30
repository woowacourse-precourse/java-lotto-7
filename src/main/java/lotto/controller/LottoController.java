package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.common.Winning;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        lottoService = new LottoService();

        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String inputPayment = inputView.readPayment();
        int payment = Integer.parseInt(inputPayment);
        int lottoCount = payment / 1000;

        List<Lotto> lottos = lottoService.initLotto(lottoCount);
        outputView.printLotto(lottoCount, lottos);

        String inputWinningNumbers = inputView.readWinningNumbers();
        String[] rawWinningNumbers = inputWinningNumbers.split(",");
        List<Integer> winningNumbers = Arrays.stream(rawWinningNumbers).map(Integer::parseInt).toList();

        String inputBonus = inputView.readBonus();
        int bonus = Integer.parseInt(inputBonus);

        Map<Winning, Integer> winnings = lottoService.getWinnings(lottos, winningNumbers, bonus);
        double yield = lottoService.getYield(payment, winnings);

        outputView.printResult(winnings, yield);
    }
}
