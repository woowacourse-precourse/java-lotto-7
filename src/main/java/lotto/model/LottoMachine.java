package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private final List<Lotto> purchasedLottos;

    public LottoMachine() {
        this.purchasedLottos = new ArrayList<>();
    }

    public List<Lotto> generateLotto(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> generatedLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(generatedLotto);
            purchasedLottos.add(new Lotto(generatedLotto));
        }

        return purchasedLottos;
    }
}
