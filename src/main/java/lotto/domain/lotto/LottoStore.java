package lotto.domain.lotto;

import java.util.List;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    public int getLottoCount(String money) {
        return Integer.parseInt(money) / LOTTO_PRICE;
    }

    public List<Lotto> buyLotto(int lottoCount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return lottoGenerator.generateLotto(lottoCount);
    }
}
