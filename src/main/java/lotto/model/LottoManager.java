package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.service.Generator;
import lotto.service.LottoGenerator;

public class LottoManager {

    private final List<Lotto> lotteries;
    private final Generator generator;

    public LottoManager() {
        generator = new LottoGenerator();
        lotteries = new ArrayList<>();
    }

    public void addLotteries(int amount) {
        lotteries.addAll(generator.generates(amount));
    }

    public Stream<Lotto> getStream() {
        return lotteries.stream();
    }
}
