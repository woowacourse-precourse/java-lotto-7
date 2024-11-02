package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class MyLottos {
    private final List<Lotto> myTickets;

    public MyLottos() {
        this.myTickets = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        myTickets.add(lotto);
    }

    public List<Lotto> getLottos() {
        return myTickets;
    }

    public int size() {
        return myTickets.size();
    }
}
