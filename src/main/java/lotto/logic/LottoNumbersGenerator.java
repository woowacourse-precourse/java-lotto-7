package lotto.logic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.input.Lotto;

public class LottoNumbersGenerator {

    private List<Lotto> lottos;

    public LottoNumbersGenerator() {
        this.lottos = new ArrayList<>();
    }

    public LottoNumbersGenerator(int count) {
        List<Lotto> lottos = generateLottos(count);
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> generateLottos(int count) {
        Set<Lotto> lottos = new HashSet<>();

        while (lottos.size() < count) {
            Lotto lotto = new Lotto(generateRandomNumbers());
            lottos.add(lotto);
        }

        return List.copyOf(lottos);
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }
}