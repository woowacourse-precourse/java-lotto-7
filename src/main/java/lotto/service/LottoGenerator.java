package lotto.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.service.strategy.DrawStrategy;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottoGenerator {
    private final DrawStrategy drawStrategy;

    public LottoGenerator(DrawStrategy drawStrategy) {
        this.drawStrategy = drawStrategy;
    }

    public Lottos generate(Integer count) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(createLottoNumber());
            list.add(lotto);
        }
        return new Lottos(list);
    }

    public List<Integer> createLottoNumber() {
        return drawStrategy.draw().stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
