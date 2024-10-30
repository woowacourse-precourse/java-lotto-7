package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private final int lottoCount;
    private final List<Lotto> purchased;

    public LottoStore(int totalCost) {
        this.lottoCount = totalCost/1000;
        this.purchased = new ArrayList<>();
    }

    public List<Lotto> issueLotto() {
        for (int i = 1; i <= lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            purchased.add(new Lotto(numbers));
        }
        return purchased;
    }
}
