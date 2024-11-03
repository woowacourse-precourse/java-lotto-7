package lotto.business;

import java.util.List;
import lotto.model.LottoNumbersGenerator;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.value.LottoNumbers;
import lotto.value.WinningStatistics;
import lotto.value.Won;

public class LottoService {

    private final Lottos lottos;

    public LottoService(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottos = Lottos.by(lottoNumbersGenerator);
    }

    public List<LottoNumbers> buyLotto(Won amountForBuy) {
        lottos.buyFor(amountForBuy);
        return lottos.getLottoNumbers();
    }

    public WinningStatistics checkWinningResults(WinningLotto winningLotto) {
        return lottos.calculateWinningStatistics(winningLotto);
    }

}
