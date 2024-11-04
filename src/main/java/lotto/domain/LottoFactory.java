package lotto.domain;

import lotto.service.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private static final int RANGE_START_NUMBER = 1;
    private static final int RANGE_END_NUMBER = 45;
    private static final int LOTTO_COUNT_NUMBER = 6;

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoFactory(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> createAllLottos(long quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = createSingleLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto createSingleLotto() {
        return new Lotto(lottoNumberGenerator.createLottoNumbers(RANGE_START_NUMBER, RANGE_END_NUMBER, LOTTO_COUNT_NUMBER));
    }
}
