package lotto.ticket;

import static lotto.ticket.Lotto.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoIssuer implements TicketIssuer {

    @Override
    public List<Ticket> issue(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        List<Ticket> lottoTickets = new ArrayList<>();
        int ticketCount = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto(createRandomNumbers());
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    @Override
    public void validatePurchaseAmount(int ticketPurchaseAmount) {
        if (ticketPurchaseAmount == 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0원보다 커야합니다.");
        }
        if (ticketPurchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 나누어 떨어져야합니다.");
        }
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
