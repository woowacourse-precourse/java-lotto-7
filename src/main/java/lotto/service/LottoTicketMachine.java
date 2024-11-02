package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoTicketMachine {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Lotto> purchaseLottoTickets(int totalPurchaseAmount) {
        int purchaseQuantity = totalPurchaseAmount / LOTTO_TICKET_PRICE;
        return generateLottoTickets(purchaseQuantity);
    }

    private List<Lotto> generateLottoTickets(int purchaseQuantity) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_SIZE);
            Lotto lottoTicket = new Lotto(numbers);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }
}
