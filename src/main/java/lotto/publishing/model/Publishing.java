package lotto.publishing.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.common.model.Lotto;

public class Publishing {
    private final int numberOfTickets;
    private List<Lotto> LottoTickets;

    public Publishing(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
        setByNumberOfTickets();
    }

    private void setByNumberOfTickets() {
        LottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            LottoTickets.add(makeRandomlyLotto());
        }
    }

    private Lotto makeRandomlyLotto() {
        List<Integer> publishedTicket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(publishedTicket);
    }

    public List<Lotto> getLottoTickets() {
        return LottoTickets;
    }
}
