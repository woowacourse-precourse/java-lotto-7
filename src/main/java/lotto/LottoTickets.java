package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> tickets=new ArrayList<>();

    public LottoTickets(int count) {
        for (int i = 0; i <count ; i++) {
            tickets.add(LottoGenerator.generate());
        }
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    public void printTickets()
    {
        for(Lotto lotto: tickets)
        {
            System.out.println(lotto.getNumbers());
        }
    }
}
