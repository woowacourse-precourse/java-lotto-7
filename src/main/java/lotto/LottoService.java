package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoDrawMachine;
import lotto.model.LottoResult;

public class LottoService {

    public Lotto makeLotto() {
        List<Integer> pickedUniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(pickedUniqueNumbers);
    }

    public LottoDrawMachine makeLottoDrawMachine(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return new LottoDrawMachine(lottos, winningNumbers, bonusNumber);
    }

    public LottoResult getWinningResult(LottoDrawMachine machine) {
        return machine.calculateLottoResult();
    }

    public double generateEarningsRate(LottoResult lottoResult, LottoDrawMachine machine) {
        long purchaseAmount = machine.getPurchaseAmount();
        return lottoResult.calculateEarningsRate(purchaseAmount);
    }

}
