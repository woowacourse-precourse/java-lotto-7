package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTicketMachine {
    public static final int LOTTO_TICKET_PRICE = 1000;

    public List<Lotto> purchaseLottoTickets(int purchaseAmount) {
        int lottoTickets = calculateTicketCount(purchaseAmount);
        return generateLottoTickets(lottoTickets);
    }

    private int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_TICKET_PRICE;
    }

    private List<Lotto> generateLottoTickets(int lottoTickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTickets; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(numbers);
    }
}
