package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoDrawMachine;

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

    //- 당첨 기준에 따라 1등~5등까지 기준에 따라 몇 개의 번호가 일치하는지 당첨 내역을 판정한다.
    public Map<Rank, Integer> getWinningResult(LottoDrawMachine machine) {
        return machine.prizeWinningResult();
    }

}
