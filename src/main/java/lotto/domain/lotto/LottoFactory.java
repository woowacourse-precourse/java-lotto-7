package lotto.domain.lotto;

import java.util.List;
import lotto.domain.number.Number;
import lotto.domain.number.Numbers;

public class LottoFactory {
    public static Lotto createCustomLotto(final List<Integer> numbers) {
        Numbers customLotto = Numbers.of(numbers);
        return new Lotto(customLotto);
    }

    public static Lotto createRandomLotto() {
        List<Integer> lottoNumbers = Numbers.generateSixRandomNumbers()
                .getNumbers()
                .stream()
                .map(Number::getNumber)
                .toList();
        Numbers randomLotto = Numbers.of(lottoNumbers);

        return new Lotto(randomLotto);
    }
}
