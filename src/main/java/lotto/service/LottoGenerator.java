package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public List<Lotto> generateLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < purchaseAmount / 1000) { // TODO 따로 빼기
            lottos.add(generateRandomLotto());
        }
        return lottos;
    }

    private Lotto generateRandomLotto() {
        List<Integer> oneLotto = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBERS_COUNT);
        return new Lotto(oneLotto);
    }
}
