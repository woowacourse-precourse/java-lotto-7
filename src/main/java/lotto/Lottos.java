package lotto;

import lotto.number.LottoNumber;
import lotto.strategy.LottoNumberStrategy;
import lotto.winner.WinnerLottoNumber;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;
    private final Map<Prize, Integer> prizes = new HashMap<>();

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void purchaseLottos(int purchaseCount, LottoNumberStrategy lottoNumberStrategy) {
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = Lotto.createOfLotto(lottoNumberStrategy.generate());
            lottos.add(lotto);
        }
    }

    public void hitLottoNumbers(WinnerLottoNumber winnerLottoNumber, LottoNumber bonusNumber) {
        lottos.forEach(lotto -> {
            Prize prize = lotto.hitLottoNumber(winnerLottoNumber, bonusNumber);
            prizes.put(prize, prizes.getOrDefault(prize, 0) + 1);
        });
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Prize, Integer> getPrizes() {
        return Collections.unmodifiableMap(prizes);
    }

}
