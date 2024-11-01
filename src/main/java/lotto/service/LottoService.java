package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.utils.LottoNumbersGenerator;

public class LottoService {
    public Lottos createLottos(int lottoQuantity) {
        List<Lotto> LottoGroup = generateLottoGroup(lottoQuantity);
        return new Lottos(LottoGroup, lottoQuantity);
    }

    public LottoGame createLottoGame(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new LottoGame(lottos, winningNumbers, bonusNumber);
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
