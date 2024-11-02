package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class MyLottos {
    private final List<Lotto> myLottos;

    public MyLottos() {
        this.myLottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        myLottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return myLottos;
    }

    public int size() {
        return myLottos.size();
    }
}
