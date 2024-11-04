package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.constant.LottoNumberRule;

public class LottoGenerator {
    private final List<Lotto> lottos;

    private LottoGenerator(int amount) {
        List<Lotto> lottos = generateLottos(amount);
        this.lottos = List.copyOf(lottos);
    }

    public static LottoGenerator generate(int amount) {
        return new LottoGenerator(amount);
    }

    private List<Lotto> generateLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int lottoCount = 0; lottoCount < amount; lottoCount++) {
            Lotto lotto = generateAscedingSortedRandomLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    private Lotto generateAscedingSortedRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
            LottoNumberRule.MIN_NUMBER.get(),
            LottoNumberRule.MAX_NUMBER.get(),
            LottoNumberRule.FIXED_SIZE.get());
        List<Integer> sortedRandomNumbers = randomNumbers.stream().sorted(Comparator.naturalOrder()).toList();

        return new Lotto(sortedRandomNumbers);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
