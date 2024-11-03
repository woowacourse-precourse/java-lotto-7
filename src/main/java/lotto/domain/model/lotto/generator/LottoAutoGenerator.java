package lotto.domain.model.lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.model.user.Lotto;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.common.constant.LottoConst.*;

public class LottoAutoGenerator implements LottoGenerator {

    @Override
    public List<Lotto> generateByQuantity(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> generateLotto())
                .toList();
    }

    @Override
    public Lotto generateLotto() {
        List<Integer> randomNumbers =
                Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, LOTTO_NUM_COUNT).stream().sorted().toList();
        return Lotto.create(randomNumbers);
    }
}
