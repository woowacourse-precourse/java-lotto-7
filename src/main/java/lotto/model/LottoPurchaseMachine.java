package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoPurchaseMachine {

    private final int purchaseAmount;

    public LottoPurchaseMachine(int purchaseAmount) {

        this.purchaseAmount = purchaseAmount;
    }

    private int calculateLottoAmount() {
        return purchaseAmount / Lotto.PRICE_PER_TICKET;
    }

    public List<Lotto> generateLottoTickets() {
        int lottoAmount = calculateLottoAmount();
        return createLottoTickets(lottoAmount);
    }

    private List<Lotto> createLottoTickets(int lottoAmount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottoTickets.add(generateSingleLottoTicket());
        }
        return lottoTickets;
    }

    private Lotto generateSingleLottoTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, Lotto.NUMBERS_COUNT);
        return new Lotto(numbers);
    }
}

