package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Lotto> lottos;

    public Lottos(int count) {
        this.lottos = new ArrayList<>();
        generateLottos(count);
    }

    private void generateLottos(int count) {
        for (int currentCount = 0; currentCount < count; currentCount++) {
            List<Integer> numbers =
                    Randoms.pickUniqueNumbersInRange(
                            MIN_LOTTO_NUMBER,
                            MAX_LOTTO_NUMBER,
                            LOTTO_SIZE
                    );
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
    }
}
