package lotto.service;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class LottoService {
    public Lottos generateLottos(int purchaseAmount) {
        List<Lotto> lottos = Stream.generate(() -> new Lotto(LottoGenerator.generate()))
                .limit(purchaseAmount)
                .toList();
        return new Lottos(lottos);
    }

    public ResultCalculator calculateResult(Lottos lottos, WinningLotto winningLotto){
        return new ResultCalculator(lottos, winningLotto);
    }

}
