package lotto.model.lottogenerator;

import java.util.List;
import lotto.model.lotto.Lotto;

public class FixedLottoNumberGenerator implements LottoGenerateStrategy {
    private int sequence;
    private final List<Lotto> fixedLottoNumbers = List.of(
            new Lotto(List.of(3, 16, 20, 35, 44, 45)),
            new Lotto(List.of(3, 16, 20, 23, 27, 45)),
            new Lotto(List.of(1, 9, 10, 16, 25, 26)),
            new Lotto(List.of(3, 16, 20, 23, 27, 7)),
            new Lotto(List.of(1, 6, 18, 21, 41, 45)),
            new Lotto(List.of(3, 16, 20, 35, 43, 45))
    );

    @Override
    public List<Integer> generate() {
        return fixedLottoNumbers.get(sequence++).getNumbers();
    }
}
