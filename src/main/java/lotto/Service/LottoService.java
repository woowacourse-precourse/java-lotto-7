package lotto.Service;

import java.util.List;
import lotto.LottoNumberGenerator;
import lotto.domain.Lotto;

public class LottoService {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> generateLottos(int amount) {
        return lottoNumberGenerator.generate(amount);
    }
}
