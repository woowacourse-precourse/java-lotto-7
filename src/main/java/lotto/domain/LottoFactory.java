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
        validate(payment);
        
        int count = (int) (payment / LOTTO_PRICE);
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(numberMachine.get()))
                .toList();

        return new Lottos(lottos);
    }

    private void validate(long payment) {
        if (payment % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] " + payment + "는 " + LOTTO_PRICE + "단위의 숫자가 아님");
        }
    }
}
