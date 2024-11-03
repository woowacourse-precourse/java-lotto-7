package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoConfig.LOTTO_START;
import static lotto.domain.LottoConfig.LOTTO_END;
import static lotto.domain.LottoConfig.LOTTO_MAX_NUMBER;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(int numberOfTickets) {
        this.lottoTickets = createUserLottoTickets(numberOfTickets);
    }

    private List<Lotto> createUserLottoTickets(int numberOfTickets) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> randoms = Randoms.pickUniqueNumbersInRange(LOTTO_START.getUnit(), LOTTO_END.getUnit(), LOTTO_MAX_NUMBER.getUnit());
            tickets.add(new Lotto(randoms));
        }

        return tickets;
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
