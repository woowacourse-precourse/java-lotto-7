package lotto.service;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Lottos;

public class LottoService {
    public Lottos generateLottos(int purchaseAmount) {
        List<Lotto> lottos = Stream.generate(() -> new Lotto(LottoNumberGenerator.generate()))
                .limit(purchaseAmount)
                .toList();
        return new Lottos(lottos);
    }

    public ResultCalculator calculateResult(Lottos lottos, Lotto winLotto, int bonusNumber){
        return new ResultCalculator(lottos, winLotto, bonusNumber);
    }

}
