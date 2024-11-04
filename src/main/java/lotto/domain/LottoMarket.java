package lotto.domain;

import static lotto.constant.Constant.LOTTO_PRICE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMarket {

    private final LottoMaker lottoMaker = new LottoMaker();

    public List<Lotto> buyLotto(Money money) {

        int lottoCount = calculateLottoCount(money);

        return Stream.generate(lottoMaker::makeLotto)
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    private int calculateLottoCount(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }
}
