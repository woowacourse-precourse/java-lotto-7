package lotto.lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.common.util.random.RandomGenerator;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoResult;

public class LottoFactory {

    private final RandomGenerator randomGenerator;

    public LottoFactory(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public List<LottoResult> generateMultipleLottos(long count) {

        List<Lotto> lottos = new ArrayList<>();

        for(long l = 0; l < count; l++) {
            List<Integer> lottoNumbers = randomGenerator.generateRandomNumbers();
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return lottos.stream().map(LottoResult::create).toList();
    }

}
