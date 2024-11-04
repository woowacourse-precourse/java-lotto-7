package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public LottoMachine(int purchaseAmount) {
        this.lottos = createLottos(purchaseAmount);
    }

    private List<Lotto> createLottos(int purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public LottoResult determineLottoResult(List<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            int matchCount = 0;
            boolean bonusMatch = false;
            for (Integer number : lotto.getNumbers()) {
                if (winningNumbers.contains(number)) {
                    matchCount++;
                }
                if (number.equals(bonusNumber)) {
                    bonusMatch = true;
                }
            }
            result.addResult(LottoRank.valueOf(matchCount, bonusMatch));
        }
        return result;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
