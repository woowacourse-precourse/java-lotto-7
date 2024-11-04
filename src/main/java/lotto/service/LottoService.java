package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;

import java.util.List;

public class LottoService {

    private final LottoMachine lottoMachine = new LottoMachine();
    private List<Lotto> lottos;
    private LottoResult lottoResult;

    public void generateLottos(int purchaseAmount) {
        this.lottos = lottoMachine.generateLottos(purchaseAmount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.lottoResult = new LottoResult(winningNumbers, bonusNumber);
    }

    public String calculateResults() {
        return lottoResult.calculateResults(lottos);
    }
}