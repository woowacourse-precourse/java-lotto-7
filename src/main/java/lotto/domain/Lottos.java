package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public long getLottoCount(){
        return lottos.size();
    }

    public void showInfo(){
        lottos.stream().map(Lotto::toString).forEach(System.out::println);
    }
}
