package lotto.publishingLotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.publishingLotto.model.Lotto;

public class PublishingService {
    private static PublishingService publishingService;

    private PublishingService() {}

    public static PublishingService getPublishingService() {
        if (publishingService == null) {
            publishingService = new PublishingService();
            return publishingService;
        }
        return publishingService;
    }

    public static Lotto publishLottoTicket() {
        List<Integer> publishedTicket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(publishedTicket);
    }

    public List<Lotto> publishByNumberOfTicket (int numberOfTickets) {
        List<Lotto> LottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            LottoTickets.add(publishLottoTicket());
        }
        return LottoTickets;
    }

}
