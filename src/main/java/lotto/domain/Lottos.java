package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<LottoGrade, Integer> convertGrades(TargetLotto targetLotto) {
        EnumMap<LottoGrade, Integer> lottoCountMap = lottos.stream()
                .map(lotto -> lotto.match(targetLotto))
                .collect(Collectors.toMap(
                        lottoGrade -> lottoGrade,
                        lottoGrade -> 1,
                        Integer::sum,
                        () -> new EnumMap<>(LottoGrade.class)
                ));

        return lottoCountMap;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
