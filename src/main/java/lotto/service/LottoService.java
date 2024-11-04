package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Lottos;
import lotto.utils.LottoNumbersGenerator;

public class LottoService {
    public Lottos createLottos(int lottoQuantity) {
        List<Lotto> LottoGroup = generateLottoGroup(lottoQuantity);
        return new Lottos(LottoGroup);
    }

    public LottoGame createLottoGame(Lottos lottos, Lotto winningLotto, BonusNumber bonusNumber) {
        return new LottoGame(lottos, winningLotto, bonusNumber);
    }

    private List<Lotto> generateLottoGroup(int lottoQuantity) {
        return IntStream.range(0, lottoQuantity)
                .mapToObj(i -> createLotto())
                .toList();
    }

    private Lotto createLotto() {
        List<Integer> numbers = LottoNumbersGenerator.generate();
        return new Lotto(numbers);
    }
}
