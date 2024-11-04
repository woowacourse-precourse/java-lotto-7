package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    public LottoBuyer getLottoBuyer(PurchaseAmount purchaseAmount) {
        return new LottoBuyer(LottoPublisher.publishLotto(purchaseAmount), purchaseAmount);
    }

    public List<Integer> compareWinningNumber(List<Lotto> lottos, WinningNumber winningNumber) {
        return lottos.stream()
                .map(winningNumber::getSameCount)
                .toList();
    }

    public List<Boolean> compareBonusNumber(List<Lotto> lottos, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.contains(bonusNumber.getBonusNumber()))
                .toList();
    }
}
