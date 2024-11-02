package lotto.domain;

import java.util.List;

public class Lottos {
    public final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validateDuplicate(lottos);
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void validateDuplicate(List<Lotto> lottos) {
        if(lottos.size() != lottos.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto.getNumbers() + "\n"));
        return sb.toString();
    }
}
