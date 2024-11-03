package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private final List<Lotto> buyingLottos;

    public LottoMachine(int amount) {
        RandomLottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();

        this.buyingLottos = IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generateLottoNumbers()))
                .toList();
    }

    public List<Lotto> getBuyingLottos() {
        return buyingLottos;
    }

    public WinningResult calculateWinningCount(WinningLotto winningNumbers) {
        return new WinningResult(winningNumbers, buyingLottos);
    }
}
