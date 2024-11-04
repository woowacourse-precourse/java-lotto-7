package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Lotties {
    private final List<Lotto> lottoTickets;

    public Lotties() {
        this.lottoTickets = new ArrayList<>();
    }

    public void addLotto(List<Integer> numbers) {
        lottoTickets.add(new Lotto(numbers));
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
