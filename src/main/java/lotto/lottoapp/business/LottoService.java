package lotto.lottoapp.business;

import java.util.List;
import lotto.lottoapp.model.LottoNumbersGenerator;
import lotto.lottoapp.model.Lottos;
import lotto.lottoapp.model.WinningLotto;
import lotto.lottoapp.model.value.LottoNumbers;
import lotto.lottoapp.model.value.WinningStatistics;
import lotto.lottoapp.model.value.Won;

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
