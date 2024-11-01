package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto(final Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        // java.lang.UnsupportedOperationException at ApplicationTest.java:59 (toList로 반환하면) -> 불변 객체 건드림
        // java.util.NoSuchElementException at ApplicationTest.java:59 (그냥 lottos 반환하면) -> 비어있어서
//        return lottos.stream().toList();
        return lottos;
    }
}
