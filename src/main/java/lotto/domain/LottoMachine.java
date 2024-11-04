package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MINIMUM_BOUND = 1;
    private static final int LOTTO_MAXIMUM_BOUND = 45;
    private final Money money;

    private LottoMachine(Money money) {
        this.money = money;
    }

    public static LottoMachine from(Money money) {
        return new LottoMachine(money);
    }

    public List<Lotto> publishLotto() {
        int lottoTicketCount = money.calculateTicketCount();
        return IntStream.range(0, lottoTicketCount)
                .mapToObj(lotto -> new Lotto(createLottoNumbers()))
                .toList();
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_MINIMUM_BOUND, LOTTO_MAXIMUM_BOUND, LOTTO_SIZE
        );
    }
}
