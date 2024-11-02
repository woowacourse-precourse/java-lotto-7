package lotto.domain;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.LottoNumber.MAX_NUMBER;
import static lotto.domain.LottoNumber.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(PurchasePrice purchasePrice) {
        for (int i = 0; i < purchasePrice.calculateLottoCount(); i++) {
            lottos.add(generateLotto());
        }
    }

    private Lotto generateLotto() {
        return Lotto.from(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE));
    }

    public int lottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoResult calculateLottoResult(WinningNumber winningNumber) {
        return new LottoResult(compareLottos(winningNumber));
    }

    private List<LottoReward> compareLottos(WinningNumber winningNumber) {
        return lottos.stream()
                .map(winningNumber::findReward)
                .toList();
    }
}
