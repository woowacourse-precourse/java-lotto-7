package lotto;

import java.util.List;

import exception.ValidationException;
import view.InputView;
import view.OutputView;


public class LottoController {

    private final LottoMachine lottoMachine = new LottoMachine();
    private final LottoResult lottoResult = new LottoResult();
    private final InputView inputView = new view.InputView();
    private final OutputView outputView = new view.OutputView();

    public void startLotto() {
        try{
            int purchaseAmount = inputView.inputPurchaseAmount();
            List<Lotto> lottoNumbers = lottoMachine.makeLottoNumbers(purchaseAmount);
            outputView.printLotto(lottoNumbers);

            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            int bonusNumber = inputView.inputBonusNumber();
            Lotto winningLotto = new Lotto(winningNumbers);

            int[] result = lottoResult.calculateRank(lottoNumbers, winningLotto, bonusNumber);
            double profitRatio = lottoResult.calculateProfitRate(result, purchaseAmount);

            outputView.printResult(result, profitRatio);
        } catch(IllegalArgumentException e){

            ValidationException.validateForm();
        }
    }
}
