package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int START_INDEX = 0;

    private final List<Lotto> lottoList;

    private Lottos(int count) {
        this.lottoList = new ArrayList<>();
        generateLottos(count);
    }

    public static Lottos from(final int count) {
        return new Lottos(count);
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    private void generateLottos(final int count) {
        IntStream.range(START_INDEX, count)
                .mapToObj(i -> Lotto.from(
                        Randoms.pickUniqueNumbersInRange(
                                MINIMUM_LOTTO_NUMBER,
                                MAXIMUM_LOTTO_NUMBER,
                                LOTTO_SIZE
                        )
                )).forEach(lottoList::add);
    }

}