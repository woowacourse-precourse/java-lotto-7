package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;

public class RandomLotteryGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT_NUMBER = 6;

    public Lotto generateEachLotto() {
        List<Integer> lotteryNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT_NUMBER);
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
