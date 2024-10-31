package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.common.Winning;
import lotto.parser.Parser;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    private final Parser parser;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoService = new LottoService();

        this.parser = new Parser();

        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String inputPayment = inputView.readPayment();
        int payment = parser.parsePayment(inputPayment);

        List<Lotto> lottos = lottoService.initLotto(payment);
        outputView.printLotto(lottos);

        String inputWinningNumbers = inputView.readWinningNumbers();
        List<Integer> winningNumbers = parser.parseWinningNumbers(inputWinningNumbers);

        String inputBonus = inputView.readBonus();
        int bonus = parser.parseBonus(inputBonus);

        Map<Winning, Integer> winnings = lottoService.getWinnings(lottos, winningNumbers, bonus);
        double yield = lottoService.getYield(payment, winnings);

        outputView.printResult(winnings, yield);
    }
}
