package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private final List<Lotto> lottoTickets;

    public User() {
        this.lottoTickets = new ArrayList<>();
    }


    public void addLottoTickets(List<Lotto> tickets) {
        lottoTickets.addAll(tickets);
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

}
