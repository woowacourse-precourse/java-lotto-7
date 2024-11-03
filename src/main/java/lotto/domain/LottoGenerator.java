package lotto.domain;

import static lotto.handler.ConstantHandler.LOTTO_SIZE;
import static lotto.handler.ConstantHandler.MAX_LOTTO_NUMBER;
import static lotto.handler.ConstantHandler.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public List<Lotto> generateLottos(int ticketCount) {
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
    }

    private Lotto generateLotto() {
        return new Lotto(generateLottoNumbers());
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
    }
}
