package lotto.domain;

import static lotto.util.LottoConstants.LOTTO_LENGTH;
import static lotto.util.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.util.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.util.LottoConstants.ZERO_THRESHOLD;

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
        List<Lotto> lotteries = LongStream.range(ZERO_THRESHOLD.getValue(), count)
                .mapToObj(i -> new Lotto(getRandomNumber()))
                .toList();
        return new LottoTickets(lotteries);
    }

    private static List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(),
                LOTTO_LENGTH.getValue());
    }

}
