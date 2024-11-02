package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        Set<String> uniqueLottos = lottos.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .collect(Collectors.toSet());

        if (uniqueLottos.size() != lottos.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또가 존재합니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size()).append("개를 구매했습니다.\n");
        lottos.forEach(lotto -> sb.append(lotto.getNumbers() + "\n"));
        return sb.toString();
    }
}
