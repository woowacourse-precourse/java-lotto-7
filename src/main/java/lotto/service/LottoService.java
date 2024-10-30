package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domains.Lotto;

public class LottoService {
    private static final int LOTTO_COST = 1_000;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public int getLottoCost() {
        return LOTTO_COST;
    }

    public int issueLottoCount(int cost) throws IllegalArgumentException {
        if (cost % LOTTO_COST > 0) {
            throw new IllegalArgumentException("[Error] 구입 금액은 " + LOTTO_COST + "원 단위이어야 합니다.");
        }

        return cost / LOTTO_COST;
    }


    public List<Lotto> issueLotto(int cost) {
        int lottoCount = issueLottoCount(cost);
        List<Lotto> issueLottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            issueLottos.add(generateLotto());
        }

        return issueLottos;
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_NUMBER_COUNT));
    }
}
