package lotto;

import java.util.List;

public class LottoConverter {

    private LottoFactory lottoFactory;
    private int lottoPrice;

    public LottoConverter(int lottoPrice) {
        this.lottoPrice = lottoPrice;
        this.lottoFactory = new LottoFactory();
    }

    public List<Lotto> convertLotto(int money) {
        int lottoCount = money / lottoPrice;
        return lottoFactory.createRandomLottos(lottoCount);
    }
}
