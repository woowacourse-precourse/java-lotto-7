package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class AutomaticLottoMachine implements LottoMachine {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

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
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
    }
}
