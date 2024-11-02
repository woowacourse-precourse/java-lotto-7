package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    final long lottoTicketCount;

    public LottoGenerator(long lottoTicketCount) {
        this.lottoTicketCount = lottoTicketCount;
    }

    public List<Lotto> getTickets() {
        List<Lotto> lottoTickets = new ArrayList<>();

        while (lottoTickets.size() < lottoTicketCount) {
            lottoTickets.add(new Lotto(getLottoNumbers()));
        }

        return lottoTickets;
    }

    private List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}