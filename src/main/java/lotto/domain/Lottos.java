package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        validate(lottos);
        return new Lottos(lottos);
    }

    private static void validate(List<Lotto> lottos) {
        isNotEmpty(lottos);
    }

    private static void isNotEmpty(List<Lotto> lottos) {
        if(lottos.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> getValue() {
        return lottos;
    }

    public Integer size() {
        return lottos.size();
    }

    public String toString() {
        StringBuilder lottoPurchaseResult = new StringBuilder();
        lottoPurchaseResult.append("\n").append(this.size()).append("개를 구매했습니다.\n");
        lottos.forEach(lotto -> {
                    lottoPurchaseResult.append("[");
                    lottoPurchaseResult.append(lotto.getValue().stream().map(LottoNumber::getValue).map(String::valueOf).collect(Collectors.joining(", ")));
                    lottoPurchaseResult.append("]\n");
                });
        return String.valueOf(lottoPurchaseResult);
    }
}
