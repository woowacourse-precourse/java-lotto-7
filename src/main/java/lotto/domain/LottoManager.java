package lotto.domain;

import static lotto.domain.Money.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final List<Lotto> lottoTickets;

    public LottoManager() {
        this.lottoTickets = new ArrayList<>();
    }

    public void buyLotto(Money money) {
        int numberOfTickets = money.getAmount() / LOTTO_PRICE;
        for (int i = 0; i < numberOfTickets; i++) {
            lottoTickets.add(generateLotto());
        }
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(numbers);
    }

    public List<Lotto> getLottoTickets() {
        return List.copyOf(lottoTickets);
    }

}
