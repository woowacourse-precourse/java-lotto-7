package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static Lottos fromCount(int count) {
        List<Lotto> lottos = Stream.generate(() ->
                        {
                            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
                            randomNumbers.sort(Comparator.naturalOrder());
                            return new Lotto(randomNumbers);
                        }
                )
                .limit(count)
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
