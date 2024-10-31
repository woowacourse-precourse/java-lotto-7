package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private final List<Lotto> lottos;

    public LottoMachine(int amount) {
        RandomLottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();

        this.lottos = IntStream.range(0, amount)
            .mapToObj(i -> new Lotto(lottoNumberGenerator.generateLottoNumbers()))
            .toList();
    }

    public List<String> getLottoNumbers() {
        return lottos.stream()
            .map(Lotto::toString)
            .toList();
    }

    public WinningCount calculateWinningCount(WinningNumbers winningNumbers) {
        return new WinningCount(winningNumbers, lottos);
    }
}
