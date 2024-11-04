package lotto.model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    public static final int LOTTO_COUNT = 6;
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static Lottos fromCount(int lottosCount) {
        List<Lotto> lottos = Stream.generate(Lottos::generateLotto)
                .limit(lottosCount)
                .toList();
        return new Lottos(lottos);
    }

    private static Lotto generateLotto() {
        List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, LOTTO_COUNT));
        randomNumbers.sort(Comparator.naturalOrder());
        return new Lotto(randomNumbers);
    }

    public List<String> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .map(String::valueOf)
                .toList();
    }

    public int getTotalPrice() {
        return lottos.size() * Lotto.PRICE;
    }
}
