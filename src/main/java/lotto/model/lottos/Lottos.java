package lotto.model.lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void createLottos(int lottoCount) {
        LottoNumbersGenerator lottoNumberGenerator = new LottoNumbersGenerator();
        IntStream.range(0, lottoCount).mapToObj(count -> new Lotto(lottoNumberGenerator.generate())).forEach(lottos::add);
    }

    public List<Lotto> get() {
        return lottos;
    }
}
