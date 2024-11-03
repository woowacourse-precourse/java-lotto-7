package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(int payAmount) {
        this.lottoList = makeLottos(payAmount);
    }

    private List<Lotto> makeLottos(int payAmount) {
        int lottoCount = payAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
