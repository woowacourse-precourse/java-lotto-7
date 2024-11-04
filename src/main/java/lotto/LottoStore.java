package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoStore {

    public List<Lotto> purchase(int amount) {
        validateAmount(amount);
        int ticketCount = amount / 1000;
        List<Lotto> lottoTickets = new ArrayList<>();
        IntStream.range(0, ticketCount)
                .forEach(i -> lottoTickets.add(generateLotto()));
        return lottoTickets;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    private void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
