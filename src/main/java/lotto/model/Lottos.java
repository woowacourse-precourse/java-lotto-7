package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_COUNT = 6;
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static Lottos fromCount(int lottosCount) {
        List<Lotto> lottos = Stream.generate(() ->
                        {
                            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                                    MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT));
                            randomNumbers.sort(Comparator.naturalOrder());
                            return new Lotto(randomNumbers);
                        }
                )
                .limit(lottosCount)
                .toList();
        return new Lottos(lottos);
    }

    public List<String> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .map(String::valueOf)
                .toList();
    }
}
