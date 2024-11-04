package lotto.domain;

import java.util.List;

public class LottoOffice {

    public List<Lotto> sellTo(int money) {
        return LottoFactory.createLottos(money / 1000);
    }

}
