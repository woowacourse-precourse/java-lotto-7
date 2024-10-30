package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Lotto> lottoTickets;

    public User() {
        this.lottoTickets = new ArrayList<>();
    }

    public void addLottoTicket(Lotto ticket) {
        this.lottoTickets.add(ticket);
    }

    public List<Lotto> getLottoTickets() {
        return new ArrayList<>(lottoTickets);  // 방어적 복사
    }

}
