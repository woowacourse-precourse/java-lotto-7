package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Consumer {
    private List<Lotto> lottoTicket = new ArrayList<>();

    public Consumer(int count) {
        for (int i = 0; i < count; i++) {
            setLotto();
        }
    }

    private void setLotto() {
        Lotto lotto = new Lotto(getNumbers());
        this.lottoTicket.add(lotto);
    }

    private List<Integer> getNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public List<Lotto> getLotto() {
        return this.lottoTicket;
    }
}
