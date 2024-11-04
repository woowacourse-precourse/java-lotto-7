package lotto.model;

import static lotto.view.OutputView.printEachLotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTickets(int ticketCount) {
        for (int count = 1; count <= ticketCount; count++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            printEachLotto(numbers);
            lottoTickets.add(new Lotto(numbers));
        }
    }

    public LottoTickets(List<List<Integer>> fixedNumbers) {
        for (List<Integer> numbers : fixedNumbers) {
            Collections.sort(numbers);
            lottoTickets.add(new Lotto(numbers));
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
