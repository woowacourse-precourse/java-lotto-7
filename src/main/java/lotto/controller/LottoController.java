package lotto.controller;

import lotto.validator.BonusNumberValidator;
import lotto.validator.PriceValidator;
import lotto.model.LottoResult;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;
import lotto.validator.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private LottoResult lottoResult = new LottoResult();
    PriceValidator validator = new PriceValidator();
    WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
    BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();


    public void run() {
        try {
            int price = inputView.printGetPurchasePrice(validator);
            userLotto = new UserLotto(price);
            outputView.printLottoCount(price);

            outputView.printUserLottoNumbers(userLotto.generateLotto());

            String winningLottoNumber = inputView.printGetWinningLottoNumber(winningNumberValidator);
            int bonusNumber = inputView.printGetBonusNumber(bonusNumberValidator, winningLottoNumber);

            winningLotto = new WinningLotto(winningLottoNumber, bonusNumber);
            lottoResult.checkLottoIsWinner(winningLotto, userLotto);

            double rateOfReturn = lottoResult.calculateRateOfReturn(userLotto);
            outputView.printResultStatistics(rateOfReturn);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
