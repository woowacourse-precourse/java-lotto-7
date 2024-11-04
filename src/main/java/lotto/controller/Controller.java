package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.service.Validator;
import lotto.util.Parser;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Controller {

    private static final int LOTTO_PRICE = 1000;
    private final Input input;
    private final Output output;
    private final Validator validator;
    private final LottoService lottoService;

    public Controller() {
        this.input = new Input();
        this.output = new Output();
        this.validator = new Validator();
        this.lottoService = new LottoService();
    }

    public void run() {
        Parser parser = new Parser(input, output, validator);

        int purchaseAmount = parser.getPurchaseAmount();
        int numberOfLotto = purchaseAmount / LOTTO_PRICE;
        output.printPurchaseCount(numberOfLotto);

        List<Lotto> purchasedLotto = lottoService.generateLottos(numberOfLotto);
        output.printPurchasedLottos(purchasedLotto);

        List<Integer> winningNumbers = parser.getWinningNumbers();
        int bonusNumber = parser.getBonusNumber(winningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Statistics statistics = lottoService.calculateStatistics(purchasedLotto, winningLotto);

        output.printStatistics(statistics, purchaseAmount);
    }


}
