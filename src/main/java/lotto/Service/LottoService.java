package lotto.Service;

import java.util.List;
import lotto.Model.Lotto;
import lotto.Model.LottoMachine;
import lotto.Model.LottoResult;
import lotto.Model.WinningLotto;

public class LottoService {
    private final LottoMachine lottoMachine;

    public LottoService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> purchaseLottos(int amount) {
        return lottoMachine.generateLottos(amount);
    }

    public LottoResult checkResults(List<Lotto> lottos, WinningLotto winningLotto) {
        return new LottoResult(lottos, winningLotto);
    }
}
