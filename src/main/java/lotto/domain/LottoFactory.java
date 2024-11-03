package lotto.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class LottoFactory {

    private final Supplier<List<Integer>> numberMachine;

    public LottoFactory(Supplier<List<Integer>> numberMachine) {
        this.numberMachine = numberMachine;
    }

    public Lottos generateLottos(int count) {
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(numberMachine.get()))
                .toList();

        return new Lottos(lottos);
    }
}
