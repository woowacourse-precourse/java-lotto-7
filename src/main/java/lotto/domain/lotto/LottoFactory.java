package lotto.domain.lotto;

import java.util.List;
import lotto.domain.number.Number;
import lotto.domain.number.Numbers;

public class LottoFactory {
    public static Lotto createCustomLotto(final List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto createRandomLotto() {
        List<Integer> lottoNumbers = Numbers.generateSixRandomNumbers()
                .getNumbers()
                .stream()
                .map(Number::getNumber)
                .toList();

        return new Lotto(lottoNumbers);
    }
}
