package lotto.model.lotto.generator;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static java.util.Comparator.naturalOrder;
import static lotto.model.lotto.Lotto.END_INCLUSIVE;
import static lotto.model.lotto.Lotto.MAX_NUMBER_COUNT;
import static lotto.model.lotto.Lotto.START_INCLUSIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;

public class RandomLottoGenerator implements LottoGenerator {

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
        return pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, MAX_NUMBER_COUNT)
                .stream()
                .sorted(naturalOrder())
                .toList();
    }
}
