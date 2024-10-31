package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.utils.LottoNumbersGenerator;

public class LottoService {
    public Lottos createLottos(int lottoQuantity) {
        List<Lotto> LottoGroup = generateLottoGroup(lottoQuantity);
        return new Lottos(LottoGroup);
    }

    public List<Lotto> convertToLottoGroup(Lottos lottos) {
        return lottos.getLottoGroup();
    }

    private static List<Lotto> generateLottoGroup(int lottoQuantity) {
        return IntStream.range(0, lottoQuantity)
                .mapToObj(i -> createLotto())
                .toList();
    }

    private static Lotto createLotto() {
        List<Integer> numbers = LottoNumbersGenerator.generate();
        return new Lotto(numbers);
    }
}
