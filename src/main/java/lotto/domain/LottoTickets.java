package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoConfig.*;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(int numberOfTickets) {
        this.lottoTickets = createLottoTickets(numberOfTickets);
    }

    private List<Lotto> createLottoTickets(int numberOfTickets) {
        return Stream.generate(() -> new Lotto(Randoms.pickUniqueNumbersInRange(
                LOTTO_START.getUnit(),
                LOTTO_END.getUnit(),
                LOTTO_NUMBER_LIMIT.getUnit())))
                .limit(numberOfTickets)
                .toList();
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
