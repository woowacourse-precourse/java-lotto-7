package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.result.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.number.WinningNumbers;
import lotto.generator.LottoNumberGenerator;

public class LottoService {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> generateLottos(int amount) {
        return lottoNumberGenerator.generate(amount);
    }

    public LottoResult createWinningResult(List<Lotto> lottos, WinningNumbers winningNumbers,
                                           PurchaseAmount purchaseAmount) {
        return LottoResult.of(lottos, winningNumbers, purchaseAmount);
    }
}
