package lotto.controller;

import lotto.enums.WinningMoney;

import lotto.service.LottoCalculateService;
import lotto.service.LottoSaveService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.UserInput;
import lotto.view.UserOutput;

import java.util.Map;

public class LottosController {
    private final LottoSaveService lottoService = new LottoSaveService();
    private final LottoCalculateService lottoCalculateService = new LottoCalculateService();
    UserInput inputView;
    UserOutput outputView = new OutputView();

    public LottosController(UserInput inputView, UserOutput outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void buy() {
        int purchaseCount = lottoService.buyLottos(inputView.inputPurchaseMoney());
        outputView.outputLottoCount(purchaseCount);
        lottoService.saveLottos(purchaseCount);
        outputView.outputStatistics(lottoService.getLottos());
        save();
    }

    public void save() {
        String winningNumber = inputView.inputWinningNumbers();
        String bonusNumber = inputView.inputBonusBumber();
        lottoService.saveWinningLotto(winningNumber);
        lottoService.saveBonusNumber(bonusNumber);
        matchLotto();
    }

    public void matchLotto() {
        lottoService.makeDataForReturn();
        Map<String, Integer> lottoMatchCount = lottoService.matchLotto();
        outputView.outputMatchResult(lottoMatchCount);
        calculate(lottoMatchCount);
    }

    public void calculate(Map<String, Integer> lottoMatchCount) {
        double profitRate = lottoCalculateService.calculateProfitRate(lottoMatchCount, lottoService.getPurchasePrice());
        outputView.outputProfitRate(profitRate);
    }
}
