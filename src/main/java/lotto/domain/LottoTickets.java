package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.LongStream;

public class LottoTickets {
    private final List<Lotto> lotteries;

    public LottoTickets(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public static LottoTickets generateLottoTickets(long count) {
        List<Lotto> lotteries = LongStream.range(0, count)
                .mapToObj(i -> new Lotto(getRandomNumber()))
                .toList();
        return new LottoTickets(lotteries);
    }

    private static List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
