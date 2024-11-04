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


    public void run() {
        String price = inputView.printGetPurchasePrice();
        userLotto = new UserLotto(price);
        outputView.printLottoCount(Integer.parseInt(price));

        outputView.printUserLottoNumbers(userLotto.generateLotto());
        String winningLottoNumber = inputView.printGetWinningLottoNumber();
        int bonusNumber = inputView.printGetBonusNumber();

        winningLotto = new WinningLotto(winningLottoNumber, bonusNumber);
        lottoResult.checkLottoIsWinner(winningLotto, userLotto);

        double rateOfReturn = lottoResult.calculateRateOfReturn(userLotto);
        outputView.printResultStatistics(rateOfReturn);
    }
}
