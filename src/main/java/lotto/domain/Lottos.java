package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.application.MakeNumbersStrategy;

public record Lottos(
        List<Lotto> value
) {

    public static Lottos from(LottoQuantity lottoQuantity, MakeNumbersStrategy makeNumbersStrategy) {
        List<Lotto> lottosTemp = new ArrayList<>();
        for (int i = 0; i < lottoQuantity.value(); i++) {
            List<Integer> numbers = makeNumbersStrategy.makeNumbers();
            lottosTemp.add(new Lotto(numbers));
        }
        return new Lottos(lottosTemp);
    }
}
