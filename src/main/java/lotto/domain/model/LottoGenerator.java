package lotto.domain.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.common.constant.LottoConst.*;

public class LottoGenerator {

    public List<Lotto> generate(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> generateLotto())
                .toList();
    }

    private Lotto generateLotto() {
        List<Integer> randomNumbers =
                Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, LOTTO_NUM_COUNT).stream().sorted().toList();
        return Lotto.create(randomNumbers);
    }
}
