package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
    private List<Lotto> lottoTicket = new ArrayList<>();

    public Consumer(int count) {
        for (int i = 0; i < count; i++) {
            setLotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    private void setLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        this.lottoTicket.add(lotto);
    }

    public List<Lotto> getLotto() {
        return this.lottoTicket;
    }
}
