package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public List<Lotto> generateLottos(int count){
        if (count <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 수는 1 이상이어야 합니다.");
        }

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }
    public LottoResult calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함될 수 없습니다.");
        }

        return new LottoResult(lottos, winningNumbers, bonusNumber);
    }
}
