package lotto.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class LottoFactory {

    public static final int LOTTO_PRICE = 1000;
    private final Supplier<List<Integer>> numberMachine;

    public LottoFactory(Supplier<List<Integer>> numberMachine) {
        this.numberMachine = numberMachine;
    }

    public Lottos generateLottos(long payment) {
        int count = (int) (payment / 1000);
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(numberMachine.get()))
                .toList();

        return new Lottos(lottos);
    }
}
