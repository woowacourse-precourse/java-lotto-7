package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class Client {

    private List<Lotto> lottos;

    public Client() {
        lottos = new ArrayList<>();
    }

    public void addLotto(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
