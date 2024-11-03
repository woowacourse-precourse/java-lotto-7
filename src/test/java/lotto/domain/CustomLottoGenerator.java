package lotto.domain;

import java.util.List;

public class CustomLottoGenerator implements LottoGenerator {

    private final List<List<Integer>> customNumbers;

    public CustomLottoGenerator(List<List<Integer>> customNumbers) {
        this.customNumbers = customNumbers;
    }

    @Override
    public Lottos generateLottos(int count) {
        List<Lotto> lottos = customNumbers.stream()
                .map(Lotto::new)
                .toList();
        return new Lottos(lottos);
    }
}
