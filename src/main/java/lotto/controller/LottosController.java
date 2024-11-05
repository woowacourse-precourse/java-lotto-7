package lotto.controller;

import lotto.enums.WinningMoney;

import lotto.service.LottoCalculateService;
import lotto.service.LottoSaveService;
import lotto.validation.LottoWinningNumberValidator;
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
        while(true)
            try {
                int purchaseCount = lottoService.buyLottos(inputView.inputPurchaseMoney());
                outputView.outputLottoCount(purchaseCount);
                lottoService.saveLottos(purchaseCount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        outputView.outputStatistics(lottoService.getLottos());
        save();
    }

    public void save() {
        while (true)
            try {
                String winningNumber = inputView.inputWinningNumbers();
                lottoService.saveWinningLotto(winningNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        while(true)
            try {
                String bonusNumber = inputView.inputBonusBumber();
                lottoService.saveBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
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
