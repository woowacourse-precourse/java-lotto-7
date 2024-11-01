package lotto.model;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.generator.LottoNumberGenerator;
import lotto.vo.BonusNumber;
import lotto.vo.TicketCount;

public class Lotteries {

    private final List<Lotto> lotteries;

    private Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries createLotteries(final TicketCount ticketCount,
                                            final LottoNumberGenerator lottoNumberGenerator) {
        List<Lotto> lotteries = IntStream.range(0, ticketCount.count())
                .mapToObj(eachTicket -> Lotto.createLottoNumber(lottoNumberGenerator))
                .toList();

        return new Lotteries(lotteries);
    }

    public List<Integer> countMatchedNumbers(final Lotto winningLottoNumber) {
        return lotteries.stream()
                .map(lotto -> lotto.countMatchedNumbers(winningLottoNumber))
                .toList();
    }

    public List<Boolean> checkBonusNumberContain(final BonusNumber bonusNumber) {
        return lotteries.stream()
                .map(lotto -> lotto.checkBonusNumberContain(bonusNumber))
                .toList();
    }

    public List<Lotto> getLotteries() {
        return List.copyOf(lotteries);
    }
}
