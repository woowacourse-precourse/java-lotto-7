package lotto.service;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.*;
import lotto.input.BonusNumberProcessor;
import lotto.input.PurchaseAmountProcessor;
import lotto.input.WinningNumberProcessor;

public class LottoService {
    public Lottos generateLottos(int purchaseAmount) {
        List<Lotto> lottos = Stream.generate(() -> new Lotto(LottoGenerator.generate()))
                .limit(purchaseAmount)
                .toList();
        return new Lottos(lottos);
    }

    public int getValidPurchaseCount(String purchaseAmount) {
        return PurchaseAmountProcessor.calculatePurchaseCount(purchaseAmount);
    }

    public Lotto getValidLotto(String winNumbers){
        List<Integer> winningNumbers = WinningNumberProcessor.processWinningNumbers(winNumbers);
        return new Lotto(winningNumbers);
    }

    public int getValidBonusNumber(String bonusNumber){
        return BonusNumberProcessor.validateAndParse(bonusNumber);
    }

    public WinningLotto createWinningLotto(String winNumbers, String bonusNumber) {
        Lotto lotto = getValidLotto(winNumbers);
        int validBonusNumber = getValidBonusNumber(bonusNumber);
        return new WinningLotto(lotto, validBonusNumber);
    }

    public WinningLotto getValidWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        Lotto lotto = new Lotto(winningNumbers);
        return new WinningLotto(lotto, bonusNumber);
    }

    public ResultCalculator calculateResult(Lottos lottos, WinningLotto winningLotto){
        return new ResultCalculator(lottos, winningLotto);
    }
}
