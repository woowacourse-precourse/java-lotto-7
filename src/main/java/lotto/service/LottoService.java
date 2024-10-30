package lotto.service;

import lotto.global.util.RandomGenerator;
import lotto.model.Lotto;

import java.util.List;

public class LottoService {
    private static final RandomGenerator randomGenerator = RandomGenerator.getInstance();

    public Lotto createLotto() {
        List<Integer> lottoNumbers = randomGenerator.generate();
        return new Lotto(lottoNumbers);
    }
}
