package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottoGroup;

    public Lottos(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public int size() {
        return lottoGroup.size();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Lottos lottos)) {
            return false;
        }
        return Objects.equals(lottoGroup, lottos.lottoGroup);
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
