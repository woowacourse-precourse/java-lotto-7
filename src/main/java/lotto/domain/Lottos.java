package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<LottoGrade, Integer> convertGrades(TargetLotto targetLotto) {
        return lottos.stream()
                .map(lotto -> lotto.match(targetLotto))
                .collect(Collectors.toMap(
                        lottoGrade -> lottoGrade,
                        lottoGrade -> 1,
                        (a, b) -> a + b,
                        () -> new EnumMap<>(LottoGrade.class)
                ));
    }

}
