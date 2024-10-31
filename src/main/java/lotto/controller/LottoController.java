package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.common.Winning;
import lotto.service.LottoService;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    private final Validator validator;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoService = new LottoService();

        this.validator = new Validator();

        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String inputPayment = inputView.readPayment();
        int payment;

        try {
            payment = Integer.parseInt(inputPayment);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시오.");
        }

        validator.validatePayment(payment);

        int lottoCount = payment / 1000;

        List<Lotto> lottos = lottoService.initLotto(lottoCount);
        outputView.printLotto(lottoCount, lottos);

        String inputWinningNumbers = inputView.readWinningNumbers();
        String[] rawWinningNumbers = inputWinningNumbers.split(",");

        List<Integer> winningNumbers;

        try {
            winningNumbers = Arrays.stream(rawWinningNumbers)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시오.");
        }

        validator.validateWinningNumbers(winningNumbers);

        String inputBonus = inputView.readBonus();

        int bonus;
        try {
            bonus = Integer.parseInt(inputBonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시오.");
        }

        validator.validateLottoNumber(bonus);

        Map<Winning, Integer> winnings = lottoService.getWinnings(lottos, winningNumbers, bonus);
        double yield = lottoService.getYield(payment, winnings);

        outputView.printResult(winnings, yield);
    }
}
