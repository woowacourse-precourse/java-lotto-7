package lotto.domain.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {
    public List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < lottoCount) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    public Lotto generateLotto() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        List<Integer> lottoNumbers = lottoNumbersGenerator.generateLottoNumbers();
        return new Lotto(lottoNumbers);
    }
}
