package lotto.model;

import lotto.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public Lottos generateLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = RandomNumberGenerator.generate();
            Lotto lotto = Lotto.of(lottoNumbers);
            lottos.add(lotto);
        }

        return Lottos.of(lottos);
    }

}
