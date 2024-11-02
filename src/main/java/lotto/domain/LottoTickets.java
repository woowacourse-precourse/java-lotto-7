package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.LongStream;

public class LottoTickets {
    private final List<Lotto> lottos;

    public LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTickets generateLottoTickets(long count) {
        List<Lotto> lottos = LongStream.range(0, count)
                .mapToObj(i -> new Lotto(getRandomNumber()))
                .toList();
        return new LottoTickets(lottos);
    }

    private static List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
