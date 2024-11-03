package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {
    private final List<Lotto> lotteries = new ArrayList<>();

    public LottoService(long numberOfLottery) {
        for (int i = 0; i < numberOfLottery; i++) {
            lotteries.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public void start() {

    }
}
