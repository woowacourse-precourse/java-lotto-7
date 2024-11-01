package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos init(List<List<Integer>> numbers) {
        List<Lotto> lottos = convertToLottoList(numbers);
        return new Lottos(lottos);
    }

    private static List<Lotto> convertToLottoList(List<List<Integer>> numbers) {
        return numbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }


}
