package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            // 구입 금액을 입력 받고 로또 구매
            int amount = InputView.getPurcahseAmount();
            List<Lotto> userLottos = lottoService.purchase(amount);
            OutputView.purchase(userLottos);

            // 당첨 번호와 보너스 번호를 입력 받음
            String winningNumbersInput = InputView.getWinningNumbers();
            Lotto winningNumbers = lottoService.parseLotto(winningNumbersInput);
            int bonusNumber = InputView.getBonusNumbers();

            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            Result result = lottoService.calculateResult(userLottos, winningLotto);


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
