package lotto.controller;

import java.util.List;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.Pocket;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        String inputMoney = InputView.requestMoney();
        int money = lottoService.moneyValidator(inputMoney);
        Pocket pocket = new Pocket(lottoService.activateLottoMachine(money));
        OutputView.printPurchasedLottoCount(pocket);

        String inputWinningNumbers = InputView.requestLottoWinningNumbers();
        List<Integer> winningLottoNumbers = lottoService.winningNumbersGenerator(inputWinningNumbers);

        String inputBonusNumber = InputView.requestLottoBonusNumber();
        BonusNumber bonusNumber = lottoService.bonusNumberGenerator(inputBonusNumber);

        

    }
}