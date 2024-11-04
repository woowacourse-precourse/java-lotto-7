package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private final List<Lotto> purchasedLottoList;

    public LottoMachine() {
        this.purchasedLottoList = new ArrayList<>();
    }

    public List<Lotto> generateLotto(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> generatedLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(generatedLotto);
            purchasedLottoList.add(new Lotto(generatedLotto));
        }

        return purchasedLottoList;
    }
}
