package lotto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final DrawStrategy drawStrategy;

    public LottoGenerator(DrawStrategy drawStrategy) {
        this.drawStrategy = drawStrategy;
    }

    public Lotto createLotto() {
        return new Lotto(createLottoNumber());
    }

    public List<Integer> createLottoNumber() {
        return drawStrategy.draw().stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
