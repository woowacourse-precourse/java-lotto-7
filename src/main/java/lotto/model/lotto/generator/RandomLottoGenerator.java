package lotto.model.lotto.generator;

import static java.util.Comparator.naturalOrder;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int COUNT = 6;

    @Override
    public Lottos generate(final int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        LongStream.range(0, lottoCount).forEach(i -> {
            List<Integer> sortedUniqueNumbers = generateSortedUniqueNumbers();
            Lotto lotto = Lotto.from(sortedUniqueNumbers);
            lottos.add(lotto);
        });
        return Lottos.from(lottos);
    }

    private List<Integer> generateSortedUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT)
                .stream()
                .sorted(naturalOrder())
                .toList();
    }
}
