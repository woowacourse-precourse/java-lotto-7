package lotto.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import lotto.domain.Lotto;

public class MockLottoGenerator implements Generator<Lotto> {

    private final Queue<Lotto> lottos;

    public MockLottoGenerator(List<Lotto> lottos) {
        this.lottos = new LinkedList<>();
        this.lottos.addAll(lottos);
    }

    @Override
    public Lotto generate() {
        validateEmpty();
        return lottos.poll();
    }

    private void validateEmpty() {
        if (lottos.isEmpty()) {
            throw new IllegalStateException();
        }
    }

}
