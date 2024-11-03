package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Count;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class LottoService {
    public Lottos buyLotto(int money) {
        Count count = Count.from(money);
        return Lottos.from(count.getCount());
    }

    public LottoMachine createLottoMachine(Lotto winnerLotto, BonusNumber bonusNumber) {
        return LottoMachine.of(winnerLotto, bonusNumber);
    }

    public BonusNumber createBonusNumber(int bonusNumber) {
        return BonusNumber.from(bonusNumber);
    }

    public Lotto createWinnerLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public Map<LottoResult, Integer> getLottoResult(LottoMachine lottoMachine, Lottos lottos) {
        Map<LottoResult, Integer> result = new EnumMap<>(LottoResult.class);
        for (Lotto lotto : lottos.getLottos()) {
            LottoResult lottoResult = lottoMachine.getLottoResult(lotto);
            result.put(lottoResult, result.getOrDefault(lottoResult, 0) + 1);
        }
        return result;
    }
}
