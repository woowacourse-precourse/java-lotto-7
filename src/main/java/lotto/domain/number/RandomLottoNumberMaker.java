package lotto.domain.number;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoNumberMaker implements NumbersMaker {
    private final static int MIN = 1;
    private final static int MAX = 45;
    private final static int COUNT = 6;

    @Override
    public List<Integer> make() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT);
    }

}
