package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    static final int SIX_DIGITS = 6;
    private final List<Lotto> lottos;

    public LottoNumberGenerator(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static List<Integer> createRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,SIX_DIGITS);
    }

}
