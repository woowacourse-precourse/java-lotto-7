package lotto.publishingLotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.publishingLotto.model.Lotto;

public class PublishingService {

    public static Lotto publishLottoTicket() {
        List<Integer> publishedNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(publishedNumber);
    }

    public List<Lotto> purchasedLottoTickets(int numberOfTicket) {
        List<Lotto> purchasedLottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfTicket; i++) {
            purchasedLottoTickets.add(publishLottoTicket());
        }
        return purchasedLottoTickets;
    }

}
