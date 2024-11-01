package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final LottoGenerator lottoGenerator;
    private List<Lotto> lottos;

    public LottoManager(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
        this.lottos = new ArrayList<>();
    }

    public void createLottos(int buyLottoCount) {
        for (int i = 0; i < buyLottoCount; i++) {
            List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
    }
}
