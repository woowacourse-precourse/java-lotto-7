package lotto;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private LottoResult lottoResult = new LottoResult();
    Validator validator = new Validator();


    public void run() {
        try {
            int price = inputView.printGetPurchasePrice(validator);
            userLotto = new UserLotto(price);
            outputView.printLottoCount(price);

            outputView.printUserLottoNumbers(userLotto.generateLotto());

            String winningLottoNumber = inputView.printGetWinningLottoNumber(validator);
            int bonusNumber = inputView.printGetBonusNumber(validator);

            winningLotto = new WinningLotto(winningLottoNumber, bonusNumber);
            lottoResult.checkLottoIsWinner(winningLotto, userLotto);

            double rateOfReturn = lottoResult.calculateRateOfReturn(userLotto);
            outputView.printResultStatistics(rateOfReturn);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
