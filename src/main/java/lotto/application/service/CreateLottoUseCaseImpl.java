package lotto.application.service;

import lotto.domain.lotto.Lotto;
import lotto.application.port.inbound.CreateLottoUseCase;
import lotto.domain.random.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class CreateLottoUseCaseImpl implements CreateLottoUseCase {
    private final RandomGenerator randomGenerator;

    public CreateLottoUseCaseImpl(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public List<Lotto> create(final int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(randomGenerator.generate()));
        }
        return lottos;
    }
}
