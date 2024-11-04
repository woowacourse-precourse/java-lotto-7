package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    List<Lotto> lottos = new ArrayList<>();
    String checkResult = "";

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    @Override
    public String toString() {
        for(Lotto lotto : lottos) {
            checkResult = checkResult + lotto.toString() + "\n";
        }
        return checkResult;
    }
}
