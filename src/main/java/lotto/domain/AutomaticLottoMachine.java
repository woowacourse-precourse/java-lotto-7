package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.common.LottoConstants;

public class AutomaticLottoMachine implements LottoMachine {

    @Override
    public LottoTickets generateLottoTickets(int ticketCount) {
        List<Lotto> lottoTickets = IntStream.range(0, ticketCount)
                .mapToObj(i -> createLotto())
                .toList();
        return new LottoTickets(lottoTickets);
    }

    private Lotto createLotto() {
        return new Lotto(generateLottoNumbers());
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER,
                LottoConstants.LOTTO_SIZE);
    }
}
