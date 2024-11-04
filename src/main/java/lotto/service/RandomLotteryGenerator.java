package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;

public class RandomLotteryGenerator {

    public Lotto generateEachLotto() {
        List<Integer> lotteryNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lotteryNumbers);
    }

    public LottoGroup generateLottoGroup(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = generateEachLotto();
            lottos.add(lotto);
        }
        return new LottoGroup(lottos);
    }
}
