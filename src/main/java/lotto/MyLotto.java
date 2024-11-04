package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class MyLotto {
    private final List<Lotto> myLotto;

    public MyLotto(int lottoCount) {
        this.myLotto = IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList();
    }

    public int getCount() {
        return myLotto.size();
    }
}
