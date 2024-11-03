package lotto.Service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumbers;
import lotto.generator.LottoNumberGenerator;

public class LottoService {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> generateLottos(int amount) {
        return lottoNumberGenerator.generate(amount);
    }

    public LottoResult createWinningResult(List<Lotto> lottos, WinningNumbers winningNumbers) {
        return LottoResult.of(lottos, winningNumbers);
    }
}
