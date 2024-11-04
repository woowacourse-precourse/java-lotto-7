package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.LottoNumberGenerator;
import lotto.utils.RandomLottoGenerator;

public class LottoFactory {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoFactory() {
        this.lottoNumberGenerator = new RandomLottoGenerator();
    }


    public List<Lotto> createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = generateLotto();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private List<Integer> generateLotto() {
        List<Integer> numbers = lottoNumberGenerator.generateNumbers();
        return numbers;
    }
}
