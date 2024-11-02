package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;

import java.util.List;
import java.util.stream.IntStream;

public class LottoService {

    public Lottos issueLottos(int count) {
        List<Lotto> newLottos = IntStream.range(0, count)
                .mapToObj(i -> issueLotto())
                .toList();
        return new Lottos(newLottos);
    }

    public LottoResult getLottoResult(Lottos lottos, WinningNumbers winningNumbers) {

        return new LottoResult(lottos.getLottos().stream()
                .map(winningNumbers::matchedResult)
                .filter(lottoPrize -> !LottoPrize.NONE.equals(lottoPrize))
                .toList());

    }

    private Lotto issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .toList();
        return new Lotto(numbers);
    }

}
