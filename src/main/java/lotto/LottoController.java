package lotto;

import java.util.*;

public class LottoController {
    private final LottoMachine lottoMachine = new LottoMachine();
    private final LottoView lottoView = new LottoView();
    private final LottoResult lottoResult = new LottoResult();

    public void start() {
        int purchaseAmount = lottoView.inputPurchaseAmount();
        List<Lotto> lottos = lottoMachine.issueLottos(purchaseAmount);
        lottoView.printLotto(lottos);

        List<Integer> winningNumbers = lottoView.inputWinningNumbers();
        int bonusNumber = lottoView.inputBonusNumber();
        Lotto winningLotto = new Lotto(winningNumbers);

        int[] resultCnt = lottoResult.calculateResult(lottos, winningLotto, bonusNumber);
        double profitRate = lottoResult.calculateProfitRate(resultCnt, purchaseAmount);

        lottoView.printResult(resultCnt, profitRate);
    }
}
