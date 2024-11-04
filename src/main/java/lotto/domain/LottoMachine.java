package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static List<LottoScore> purchaseLottoTickets(int purchaseAmount, int ticketPrice) {
        int ticketCount = purchaseAmount / ticketPrice;
        List<LottoScore> purchasedLotto = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            purchasedLotto.add(LottoScore.newInstance());
        }
        return purchasedLotto;
    }
}
