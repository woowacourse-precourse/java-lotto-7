package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.utils.LottoNumberGenerator;
import lotto.utils.LottoNumberGeneratorStrategy;

public class LottoMachine {
    private final Lottos lottos;

    private LottoMachine(int amount, LottoNumberGeneratorStrategy strategy) {
        this.lottos = generateLottos(amount / 1000, strategy);
    }

    public static LottoMachine initializeWith(int amount, LottoNumberGeneratorStrategy strategy) {
        return new LottoMachine(amount, strategy);
    }

    private Lottos generateLottos(int count, LottoNumberGeneratorStrategy strategy) {
        List<Lotto> lottoBox = new ArrayList<>();

        while (lottoBox.size() < count) {
            List<Integer> lottoNumbers = LottoNumberGenerator.from(strategy).generate();
            lottoBox.add(Lotto.from(lottoNumbers));
        }
        return Lottos.from(lottoBox);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
