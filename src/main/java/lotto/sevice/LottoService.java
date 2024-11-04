package lotto.sevice;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoGenerator generator;

    public LottoService() {
        this.generator = new LottoGenerator();
    }

    public List<Lotto> issueLottos(int purchaseCount) {
        List<Lotto> issuedLottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            issuedLottos.add(generator.generate());
        }

        return issuedLottos;
    }
}
