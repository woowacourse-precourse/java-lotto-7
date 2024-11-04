package lotto.domain;

import lotto.generator.RandomValueGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(RandomValueGenerator generator, int lottoCount) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(generator.generate()));
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
