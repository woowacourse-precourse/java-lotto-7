package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTicketMachine {
    public static final int LOTTO_TICKET_PRICE = 1000;

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        int lottoCount = calculateLottoCount(purchaseAmount);
        return generateLottoTickets(lottoCount);
    }

    public int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_TICKET_PRICE;
    }

    public List<Lotto> generateLottoTickets(int lottoTickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTickets; i++) {
            lottos.add(LottoTicketMachine.generateLotto());
        }
        return lottos;
    }

    public static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Lotto.LOTTO_NUMBER_MIN,
                Lotto.LOTTO_NUMBER_MAX,
                Lotto.LOTTO_SIZE
        );
        return new Lotto(numbers);
    }
}
