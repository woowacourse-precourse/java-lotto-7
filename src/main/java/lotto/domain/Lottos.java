package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.generator.LottoNumberGenerator;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto(LottoNumberGenerator lottoNumberGenerator) {
        List<Integer> numbers = new ArrayList<>(lottoNumberGenerator.generate());
        Collections.sort(numbers);
        lottos.add(new Lotto(numbers));
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

}