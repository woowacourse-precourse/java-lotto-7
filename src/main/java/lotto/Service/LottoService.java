package lotto.Service;

import java.util.List;
import lotto.Lotto;
import lotto.LottoGenerator;

public class LottoService {
    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> purchaseLottos(int amount) {
        return lottoGenerator.generate(amount);
    }
}
