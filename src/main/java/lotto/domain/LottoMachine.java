package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> createLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    public Lotto createLotto() {
        List<Integer> numbers = lottoNumberGenerator.generateLottoNumber();
        return new Lotto(numbers);
    }

    public List<Lotto> createLotto(List<Integer> numbers) {
        return List.of(new Lotto(numbers));
    }
}
