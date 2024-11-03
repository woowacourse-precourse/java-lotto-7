package lotto;
import java.util.ArrayList;
import java.util.List;

public class LottoCollection {
    private final List<Lotto> tickets;

    public LottoCollection(int num) {
        this.tickets = new ArrayList<>();
        for (int index = 0; index < num; index++) {
            tickets.add(new Lotto());
        }
    }

    public List<Lotto> getTickets () {
        return tickets;
    }
}
