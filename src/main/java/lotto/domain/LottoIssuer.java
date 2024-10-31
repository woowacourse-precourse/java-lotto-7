package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {
    private final LottoGenerator lottoGenerator;

    public LottoIssuer(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> issueLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(lottoGenerator.issueLotto());
        }
        return lottos;
    }
}
