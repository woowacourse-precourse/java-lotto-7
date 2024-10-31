package lotto.domain.entity;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    public static final int NUMBER_OF_LOTTOS = 6;

    @Override
    public Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, NUMBER_OF_LOTTOS));
    }
}
