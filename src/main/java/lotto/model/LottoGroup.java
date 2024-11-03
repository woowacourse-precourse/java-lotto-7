package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGroup {
    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;

    private final List<Lotto> lottos;

    public LottoGroup(long numLotto) {
        lottos = generateLottos(numLotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Lotto> generateLottos(long numLotto) {
        List<Lotto> generatedLottos = new ArrayList<>();
        Set<Integer> lottoIds = new HashSet<>();

        while (needsMoreLottos(numLotto, generatedLottos)) {
            Lotto newLotto = generateLotto();
            addIfNotDuplicated(lottoIds, newLotto, generatedLottos);
        }

        return generatedLottos;
    }

    private static void addIfNotDuplicated(Set<Integer> lottoIds, Lotto newLotto, List<Lotto> generatedLottos) {
        if (isNotDuplicateId(lottoIds, newLotto)) {
            generatedLottos.add(newLotto);
            lottoIds.add(newLotto.getId());
        }
    }

    private static boolean isNotDuplicateId(Set<Integer> lottoIds, Lotto newLotto) {
        return !lottoIds.contains(newLotto.getId());
    }

    private static boolean needsMoreLottos(long numLotto, List<Lotto> generatedLottos) {
        return generatedLottos.size() < numLotto;
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START, END, COUNT);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
