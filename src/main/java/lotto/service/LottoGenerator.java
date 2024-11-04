package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public Lottos generateLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        while (purchaseCount > 0) {
            lottos.add(generateLotto());
            purchaseCount -= 1;
        }
        return new Lottos(lottos);
    }

    public Lotto generateLotto() {
        List<Integer> lotto = generateLottoNumbers().stream()
                .sorted()
                .toList();
        return new Lotto(lotto);
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
