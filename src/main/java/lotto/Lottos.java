package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottoGroup;

    public Lottos(List<Lotto> lottos) {
        this.lottoGroup = lottos;
    }

    public int size() {
        return lottoGroup.size();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Lottos lottos1)) {
            return false;
        }
        return Objects.equals(lottoGroup, lottos1.lottoGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoGroup);
    }

    @Override
    public String toString() {
        return lottoGroup.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
