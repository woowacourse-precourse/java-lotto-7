package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private static final int STANDARD_UNIT = 1_000;

    private NumberGenerator numberGenerator;

    public LottoFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos createLottos(int money) {
        int quantity = money / STANDARD_UNIT;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto(numberGenerator.generate());
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }
}
