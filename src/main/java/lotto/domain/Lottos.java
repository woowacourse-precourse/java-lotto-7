package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.application.MakingNumbersStrategy;

public record Lottos(
        List<Lotto> value
) {

    public static Lottos from(LottoQuantity lottoQuantity, MakingNumbersStrategy makingNumbersStrategy) {
        List<Lotto> lottosTemp = new ArrayList<>();
        for (int i = 0; i < lottoQuantity.value(); i++) {
            List<Integer> numbers = makingNumbersStrategy.makeNumbers();
            lottosTemp.add(new Lotto(numbers));
        }
        return new Lottos(lottosTemp);
    }
}
