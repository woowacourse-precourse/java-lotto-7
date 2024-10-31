package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottoManager {

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_CNT = 6;

    private Lottos lottos;
    private final NumberGenerate lottoGenerator;

    public LottoManager(NumberGenerate lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos buyLotto(int money) {
        int lottoCnt = money / LOTTO_PRICE;

        // 로또 발행
        List<Lotto> tmpLottos = new ArrayList<>();
        for (int cnt = 0; cnt < lottoCnt; cnt++) {
            List<Integer> numbers = lottoGenerator.randomGenerateInRange(1, 45, LOTTO_CNT);
            tmpLottos.add(new Lotto(numbers));
        }

        return lottos = new Lottos(tmpLottos);
    }
}
