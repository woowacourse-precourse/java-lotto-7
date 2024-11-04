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

    public void compareWinning(LottoDrawMachine machine) {
        machine.compareLottoToWinning();
    }

    public LottoResult getWinningResult(LottoDrawMachine machine) {
        return machine.prizeWinningResult();
    }

    public Double generateEarningsRate(LottoDrawMachine machine) {
        return machine.calculateEarningsRate();
    }
}
