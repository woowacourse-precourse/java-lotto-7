package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class MyLottos {
    private final List<Lotto> myTickets = new ArrayList<Lotto>();

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
