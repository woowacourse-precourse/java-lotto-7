package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResults;

public class LottoService {
    private final LottoMachine lottoMachine = new LottoMachine();

    public List<Lotto> generateLottos(int purchaseAmount) {
        return IntStream.range(0, purchaseAmount / 1000)
                .mapToObj(idx -> new Lotto(lottoMachine.genearteLottos()))
                .collect(Collectors.toList());
    }

    public LottoResults calculateResult(List<Lotto> userLottos, Lotto winningLotto, int bonusNumber) {
        LottoResults results = new LottoResults(userLottos, winningLotto, bonusNumber);
        results.calculateResult();
        return results;
    }
}
